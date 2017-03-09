package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Connection con;
    static Statement st;
    static PreparedStatement ps;
    static ResultSet rs;
    static Statement st1;
    static PreparedStatement ps1;
    static ResultSet rs1;
    static Statement st2;
    static PreparedStatement ps2;
    static ResultSet rs2;
    static Statement st3;
    static ResultSet rs3;
    static Statement st4;
    static Statement ps4;
    static ResultSet rs4;
    static Statement ps5;
    static ResultSet rs5;

    private static final String URL = "jdbc:oracle:thin:@10.7.124.101:1521:INFO";
    private static final String USER = "metasonic";
    private static final String PWD = "metasonic";
    public static void main(String[] args) throws SQLException {
        String query = "SELECT CARD_ID, POSTAMT_INDEX, POSTAMT_NAME FROM  RUSPOST_OFFICE_CARD WHERE UFPS_INDEX = ?";
        String query0 = "SELECT DISTINCT POSTAMT_INDEX, POSTAMT_NAME FROM  RUSPOST_OFFICE_CARD WHERE UFPS_INDEX = ?";
        String ufps_index = null;
        String postamt_index = null;
        String postamt_name = null;
        String card_id = null;
        ArrayList<String> postamt_names = new ArrayList<>();
        ArrayList<String> distinct_postamt_names = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            ufps_index = sc.nextLine();
            System.out.println(ufps_index);
        }
        try {
            con = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("connection is set");
            ps = con.prepareStatement(query);
            ps.setString(1, ufps_index);
            rs = ps.executeQuery();
            while (rs.next()) {
                postamt_index = rs.getString("POSTAMT_INDEX");
                postamt_name = rs.getString("POSTAMT_NAME");
                //card_id = rs.getString("CARD_ID");

                //System.out.println(postamt_name + " " + postamt_index);
                String full_postamt_name = postamt_name + " " + postamt_index;
                postamt_names.add(full_postamt_name);
            }
            System.out.println(postamt_names.size());
            if (postamt_names.size() == 0) {
                System.out.println("Все заполнено. QWE");
                //the end
            } else {
                con = DriverManager.getConnection(URL, USER, PWD);
                System.out.println("connection is set");
                ps1 = con.prepareStatement(query0);
                ps1.setString(1, ufps_index);
                rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    postamt_index = rs1.getString("POSTAMT_INDEX");
                    postamt_name = rs1.getString("POSTAMT_NAME");
                    System.out.println(postamt_name + " " + postamt_index);
                    //String full_postamt_name = postamt_name + " " + postamt_index;
                    distinct_postamt_names.add(postamt_index);
                }
                System.out.println(distinct_postamt_names.size());
                setOneOPSforOnePostamt(ufps_index);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs1 != null)
                    rs1.close();
                if (ps1 != null)
                    ps1.close();
                if (con != null)
                    con.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void setOneOPSforOnePostamt(String ufps_index) throws SQLException {
        System.out.println("setOneOPSforOnePostamt start");
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имена пользователей ОПС: ");
        while (sc.hasNextLine()) {
            String name = sc.nextLine();
            if (name.equals("q")){
                break;
            }
            names.add(name.toUpperCase());
        }
        System.out.println(names);

        for (int j = 0; j < names.size(); j++) {
            System.out.println("Введите индексы ОПС: ");
            if (sc.hasNextLine()) {
                String[] index_OPS = sc.nextLine().split(", ");
                for (int i = 0; i < index_OPS.length; i++) {
                    System.out.println("UPDATE RUSPOST_OFFICE_CARD" +
                            "  SET OFFICE_MANAGER = '" + names.get(j) + "', OFFICE_EMAIL = '" + getMail(names.get(j)) + "' WHERE UFPS_INDEX = '" + ufps_index + "' AND office_INDEX = '" + index_OPS[i] + "';");
                }
            }
            String name = sc.nextLine();
            if (name.equals("q")){
                break;
            }
        }
    }

    public static String getMail(String name) throws SQLException {
        //System.out.println("getMail start");
        String mail = null;
        String query3 = "SELECT ATTRIBUTEVALUE FROM UM_USER_ATTRIBUTES, UM_USER WHERE UM_USER_ATTRIBUTES.UM_USER = UM_USER.ID AND UM_USER.NAME = '"+ name +"'  AND UM_USER_ATTRIBUTES.ATTRIBUTENAME != 'password'";
        con = DriverManager.getConnection(URL, USER, PWD);
        st3 = con.createStatement();
        rs3 = st3.executeQuery(query3);
        while (rs3.next()){
            mail = rs3.getString("ATTRIBUTEVALUE");
            //System.out.println(mail);
        }
        return mail;
    }
}

package com.company.addTasks.firstTask;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*System.out.println("Введите IP адрес: ");
        if (sc.hasNextLine()){
            String IP = sc.nextLine();
            System.out.println(checkIP(IP));
        }*/
        System.out.println("Введите e-mail адрес: ");
        if (sc.hasNextLine()){
            String mail = sc.nextLine();
            System.out.println(checkMail(mail));
        }
    }

    public static boolean checkIP(String IP){
        Pattern p = Pattern.compile("" +
                "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        Matcher m = p.matcher (IP);
        return m.matches();
    }

    public static boolean checkMail(String mail){
        Pattern p = Pattern.compile("^[-A-z0-9!#$%&'*+-/=?^_`{|}~]+(\\.[-A-z0-9!#$%&'*+-/=?^_`{|}~]+)*@" +
                "([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*[a-z]{2,6}$");
        //Pattern p = Pattern.compile("^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*" +
        //"(?:aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$");
        Matcher m = p.matcher (mail);
        return m.matches();
    }
}

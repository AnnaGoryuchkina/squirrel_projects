package com.company;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.exp;
import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {

        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int sigma = 0;
        int mu = 1;
        String intValues = null;
        int step = 0;
        //String s = new String("Введите mu и sigma (только целые числа): ".getBytes("UTF-8"), "UTF-8");
        String s = "Введите mu и sigma (только целые числа): ";
        System.out.println(s);
        if (sc.hasNextLine()) {
            mu = sc.nextInt();
        }
        System.out.println("mu  = " + mu);
        if (sc.hasNextLine()) {
            sigma = sc.nextInt();
        }
        System.out.println("sigma = " + sigma);

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите интервал для распределения (значения вводяться через пробел): ");
        if (sc1.hasNextLine()) {
            intValues = sc1.nextLine();
        }
        String[] interval = intValues.split(" ");
        if (Integer.parseInt(interval[0]) > Integer.parseInt(interval[1])) {
            int tmp = Integer.parseInt(interval[1]);
            interval[1] = interval[0];
            interval[0] = String.valueOf(tmp);
        }
        System.out.println("Начало интервала = " + interval[0] + ", конец интервала = " + interval[1] + ".");

        System.out.println("Введите шаг (целое число): ");
        if (sc1.hasNextLine()) {
            step = sc1.nextInt();
        }

        Map<Integer, Integer> result = returnNumber(mu, sigma, interval, step);
        System.out.println("Результат: " + result);
        //Double num = (r.nextGaussian()*sigma + mu);
        //System.out.println(num);
    }

    /*

     */
    public static Map<Integer, Integer> returnNumber(int mu, int sigma, String[] interval, int step){
        int[] keys = getXs(interval, step);
        Map<Integer, Integer> result = new HashMap<>();
        for (int j = 0; j<keys.length; j++) {
            int value = (int)((1 / (sigma * sqrt(2 * Math.PI)) * exp((-(keys[j] - mu) *(keys[j] - mu))/ (2 * sigma* sigma)))*1000000);
            result.put(keys[j], value);
        }
        return result;
    }

    /*
    Получаем кол-во интервалов (деля отрезок на шаг) и значения X.
     */
    public static int[] getXs(String[] interval, int step){
        int numOfInt = ((Integer.parseInt(interval[1]) - Integer.parseInt(interval[0]))/step); //добавить проверку, что при вводе значений, интервал и шаг "взаимозаполнют" друг друга
        //System.out.println(numOfInt);
        int[] xs = new int[numOfInt +1];
        int x = Integer.parseInt(interval[0]);
        for (int i =0; i<= numOfInt; i++){
            xs[i] = x;
            //System.out.println(xs[i]);
            x = x + step;
        }
        return xs;
    }
}

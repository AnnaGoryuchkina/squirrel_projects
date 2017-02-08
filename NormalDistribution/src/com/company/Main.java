package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.exp;
import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
	Random r = new Random();
        int sigma = 2; //только целое число
        int mu = 3; //только целое число
        int[] interval = new int[2];
        double step = 0.5;
        interval[0]=1;
        interval[1]=5;
        Map<Double, Double> result= returnNumber(mu,sigma,interval, step);
        System.out.println(result);
        //Double num = (r.nextGaussian()*sigma + mu);
        //System.out.println(num);
    }

    public static Map<Double, Double> returnNumber(int mu, int sigma, int[] interval, double step){
        double[] keys = getXs(interval, step);
        Map<Double, Double> result = new HashMap<>();
        for (int j = 0; j<keys.length; j++) {
            double value = 1 / (sigma * sqrt(2 * Math.PI)) * exp((-(keys[j] - mu) *(keys[j] - mu))/ (2 * sigma* sigma));
            result.put(keys[j], value);
        }
        return result;
    }

    public static double[] getXs(int[] interval, double step){
        int numOfInt = (int) ((interval[1] - interval[0])/step); //добавить проверку, что при вводе значений, интервал и шаг "взаимозаполнют" друг друга
        System.out.println(numOfInt);
        double[] xs = new double[numOfInt +1];
        double x = interval[0];
        for (int i =0; i<= numOfInt; i++){
            xs[i] = x;
            System.out.println(xs[i]);
            x = x + step;
        }
        return xs;
    }
}

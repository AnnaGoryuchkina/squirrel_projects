package com.company.addTasks.firstTask;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            arrList.add(i, r.nextInt(20));
            int el = arrList.get(i);
            System.out.print(el + " ");
        }

        System.out.println();

        LinkedList<Integer> linkList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkList.add(i, r.nextInt(20));
            int el1 = linkList.get(i);
            System.out.print(el1 + " ");
        }

        System.out.println();

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int j = r.nextInt(10);
            System.out.print(j + "-");
            if (hashSet.contains(j)) {
                continue;
            } else {
                hashSet.add(j);
            }
        }
        System.out.print(hashSet);

        System.out.println();

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            int j = r.nextInt(10);
            System.out.print(j + "-");
            if (treeSet.contains(j)) {
                continue;
            } else {
                treeSet.add(j);
            }
        }
        System.out.print(treeSet);
    }
}

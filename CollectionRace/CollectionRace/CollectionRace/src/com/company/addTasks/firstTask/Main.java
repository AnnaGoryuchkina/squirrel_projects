package com.company.addTasks.firstTask;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Object> arrList = new ArrayList<>();
        LinkedList<Object> linkList = new LinkedList<>();
        HashSet<Object> hashSet = new HashSet<>();
        TreeSet<Object> treeSet = new TreeSet<>();

        Collections coll = new Collections();

        coll.fullFill(arrList);
        coll.fullFill(linkList);
        coll.fullFill(hashSet);
        coll.fullFill(treeSet);

        /*
        Add first elements into collections
         */
        List<Object> arrList1 = coll.addFirst(arrList);
        System.out.print("\033[31;1m"+ arrList1.get(0)+ "\033[39;49m ");
        for (int i =1; i < arrList1.size(); i++){
            System.out.print(arrList1.get(i) + " ");
        }


        List<Object> linkList1 = coll.addFirst(linkList);
        System.out.print("\033[31;1m"+ linkList.get(0)+ "\033[39;49m ");
        for (int i =1; i < linkList.size(); i++){
            System.out.print(linkList.get(i) + " ");
        }

        List<Object> hashSet1 = coll.addFirst(hashSet);
        System.out.print("\033[31;1m"+ hashSet1.get(0)+ "\033[39;49m ");
        for (int i =1; i < hashSet1.size(); i++){
            System.out.print(hashSet1.get(i) + " ");
        }

        Set<Object> treeSet1 = coll.addFirst(treeSet);
        Iterator<Object> itr = treeSet1.iterator();
        if (itr.hasNext()) {
            int a = (int)itr.next();
            System.out.print("\033[31;1m" + a + "\033[39;49m ");
        }
        while (itr.hasNext()){
            System.out.print(itr.next() + " ");
        }

        /*
        Searching of the element
         */
        System.out.println("\nВведите число, которое программа будет искать и удалять из коллекций.");
        int num = 0;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()){
            num= sc.nextInt();
        }

        System.out.println(coll.contains(arrList, num));
        System.out.println(coll.contains(linkList, num));
        System.out.println(coll.contains(hashSet, num));
        System.out.println(coll.contains(treeSet, num));

        /*
        Removing element if it exists
         */

        //почему -то в arrList и linkList кол-во элементов 11 перед выполнением операции удаления и поиска, а в set 10 - !!!
        System.out.println("1: " + arrList);
        coll.remove(arrList, num);
        System.out.println("2: " + linkList);
        coll.remove(linkList, num);
        System.out.println("3: " + hashSet);
        coll.remove(hashSet, num);
        System.out.println("4: " + treeSet);
        coll.remove(treeSet, num);
    }
}

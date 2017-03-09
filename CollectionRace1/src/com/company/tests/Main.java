package com.company.tests;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ArrayList<Integer> arrList = new ArrayList<>(); //1
        LinkedList<Integer> linkList = new LinkedList<>(); //2
        HashSet<Integer> hashSet = new HashSet<>(); //3
        TreeSet<Integer> treeSet = new TreeSet<>(); //4

        //Maps to collecting operations time
        Map<Integer, Long> addFirstTime = new HashMap<>();
        Map<Integer, Long> containsTime = new HashMap<>();
        Map<Integer, Long> removeTime = new HashMap<>();

        CollectionActions coll = new CollectionActions();

        coll.fullFill(arrList);
        coll.fullFill(linkList);
        coll.fullFill(hashSet);
        coll.fullFill(treeSet);

        /*
        Add first element for List and add element for Set.
         */
        addFirstTime.put(1, coll.addFirst(arrList));
        addFirstTime.put(2, coll.addFirst(linkList));
        addFirstTime.put(3, coll.addFirst(hashSet));
        addFirstTime.put(4, coll.addFirst(treeSet));

        /*
        Searching of the element
         */
        containsTime.put(1, coll.contains(arrList));
        containsTime.put(2, coll.contains(linkList));
        containsTime.put(3, coll.contains(hashSet));
        containsTime.put(4, coll.contains(treeSet));

        /*
        Removing element if it exists
         */
        removeTime.put(1, coll.remove(arrList));
        removeTime.put(2, coll.remove(linkList));
        removeTime.put(3, coll.remove(hashSet));
        removeTime.put(4, coll.remove(treeSet));


        
        System.out.format("\n%s\t%s\t%s\t%s\n", "ArrayList", addFirstTime.get(1), containsTime.get(1), removeTime.get(1));
        System.out.format("%s\t%s\t%s\t%s\n", "LinkedList", addFirstTime.get(2), containsTime.get(2), removeTime.get(2));
        System.out.format("%s\t%s\t%s\t%s\n", "HashSet", addFirstTime.get(3), containsTime.get(3), removeTime.get(3));
        System.out.format("%s\t%s\t%s\t%s\n", "TreeSet", addFirstTime.get(4), containsTime.get(4), removeTime.get(4));
    }
}

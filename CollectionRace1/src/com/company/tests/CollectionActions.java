package com.company.tests;


import java.util.*;

public class CollectionActions{
    Random r = new Random();

    public List<Integer> fullFill (List<Integer> collection) {//перегрузка методов
        for (int i = 0; i < 1000; i++) {
            (collection).add(i, r.nextInt());
        }
        System.out.println(collection);
        return collection;
    }

    public Set<Integer> fullFill (Set<Integer> collection) {
        //set collection size fixed - 1 mln
        ADD: for (int i = 0; i < 1000; i++) {
            int element = 1 + r.nextInt();
            if (collection.contains(element)){
                i--;
            }
            (collection).add(element);
        }
        System.out.println(collection);
        return collection;
    }

    public Long addFirst(List<Integer> collection) throws IllegalAccessException, InstantiationException {
        List<Integer> arTmp = collection.getClass().newInstance();
        arTmp.addAll(collection);
        long start = System.nanoTime();
        arTmp.add(0, r.nextInt());
        long finish = System.nanoTime();
        long avTime = finish - start;
        System.out.println("\navTime for adding first element: " + avTime);
        System.out.println("arTmp: " + arTmp);
        System.out.println("collection: " + collection);
        return avTime;
    }

    public Long addFirst(Set<Integer> collection) throws IllegalAccessException, InstantiationException {
        //first find the smallest element in the set, and add the new element which is smaller.
        Set<Integer> setTmp = collection.getClass().newInstance();
        setTmp.addAll(collection);
        Iterator<Integer> itr = setTmp.iterator();
        int newE = r.nextInt();
        for (int i = 0; i< setTmp.size(); i++) {
            if (itr.equals(newE)) {
                newE = r.nextInt();
                i = 0;
            }
        }
        long start = System.nanoTime();
        setTmp.add(newE);
        long finish = System.nanoTime();
        long avTime = finish - start;
        System.out.println("\navTime for adding element: " + avTime);
        System.out.println("setTmp: " + setTmp);
        System.out.println("collection: " + collection);
        return avTime;
    }

    /*public Long addFirst(HashSet<Integer> collection) throws IllegalAccessException, InstantiationException {
        //first sorted HashSet and add new element into the sorted list.
        List sortedHash = new ArrayList(collection);
        Collections.sort(sortedHash);
        long start = System.nanoTime();
        //newElement = r.nextInt((int)sortedHash.get(0));
        //System.out.println(newElement);
        //sortedHash.add(0, newElement);
        Set setTmp = collection.getClass().newInstance();
        setTmp.addAll(collection);
        setTmp.add(r.nextInt()); //check if the element already exists in the set
        long finish = System.nanoTime();
        long avTime = finish - start;
        System.out.println("\navTime for adding first element: " + avTime);
        System.out.println("sortedHash: " + sortedHash);
        System.out.println("collection: " + collection);
        return avTime;
    }*/



    public Long contains(List<Integer> collection) {
        int element = collection.get(r.nextInt(collection.size()));
        long start = System.nanoTime();
        collection.contains(element);
        long finish = System.nanoTime();
        long avTime = finish - start;
        System.out.println("\navTime for searching the element: " + avTime);
        //System.out.println(result);
        return avTime;
    }

    public Long contains(Set<Integer> collection) {
        int element = (int)collection.toArray()[r.nextInt(collection.size())];
        long start = System.nanoTime();
        collection.contains(element);
        long finish = System.nanoTime();
        long avTime = finish - start;
        System.out.println("\navTime for searching the element: " + avTime);
        return avTime;
    }

    public Long remove(List<Integer> collection) {
        int element = r.nextInt(collection.size());
        long start = System.nanoTime();
        collection.remove(element);
        long finish = System.nanoTime();
        long avTime = finish - start;
        System.out.println("\navTime for removing: " + avTime);
        System.out.println(collection);
        return avTime;
    }

    public Long remove(Set<Integer> collection) {
        int element = (int)collection.toArray()[r.nextInt(collection.size())];
        long start = System.nanoTime();
        collection.remove(element);
        long finish = System.nanoTime();
        long avTime = finish - start;
        System.out.println("\navTime for removing: " + avTime);
        System.out.println(collection);
        return avTime;
    }
}


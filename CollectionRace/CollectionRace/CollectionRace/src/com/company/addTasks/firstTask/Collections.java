package com.company.addTasks.firstTask;



import java.util.*;

public class Collections{
    Random r = new Random();

    public List<Object> fullFill (List<Object> collection) {
                for (int i = 0; i < 10; i++) {
                    (collection).add(i, r.nextInt(100));
                }
        System.out.println(collection);
            return collection;
    }

    public Set<Object> fullFill (Set<Object> collection) {
        //set collection size fixed - 10
        ADD: for (int i = 0; i < 10; i++) {
            int element = 1 + r.nextInt(100);
            if (collection.contains(element)){
                i--;
            }
            (collection).add(element);
        }
        System.out.println(collection);
        return collection;
    }

    Object minElement = 999999999;
    Object tmp = 0;
    Object newElement = 0;

    public List<Object> addFirst(List<Object> collection) {
            long start = System.nanoTime();
            collection.add(0, r.nextInt(100));
            long finish = System.nanoTime();
            long avTime = finish - start;
            System.out.println("\n" + avTime);
        return collection;
    }

    public Set<Object> addFirst(TreeSet<Object> collection) {
        //first find the smallest element in the set, and add the new element which is smaller.
        long start = System.nanoTime();
        Iterator<Object> itr = collection.iterator();
            while (itr.hasNext()){
                tmp = itr.next();
                minElement = Math.min((int)minElement, (int)tmp);
            }
            newElement = r.nextInt((int)minElement);
            collection.add(newElement);
        long finish = System.nanoTime();
        long avTime = finish - start;
        System.out.println("\n" + avTime);
        return collection;
    }

    public List<Object> addFirst(HashSet<Object> collection) {
        //first sorted HashSet and add new element into the sorted list.
        List sortedHash = new ArrayList(collection);
        java.util.Collections.sort(sortedHash);
        //System.out.println(sortedHash);
        long start = System.nanoTime();
        newElement = r.nextInt((int)sortedHash.get(0));
        //System.out.println(newElement);
        sortedHash.add(0, newElement);
        long finish = System.nanoTime();
        long avTime = finish - start;
        System.out.println("\n" + avTime);
        return sortedHash;
    }



    public boolean contains(List<Object> collection, Object element) {
        long start = System.nanoTime();
        boolean result = false;
        try {
            result = collection.contains(element);
            long finish = System.nanoTime();
            long avTime = finish - start;
            System.out.println(avTime);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean contains(Set<Object> collection, Object element) {
        Iterator<Object> itr = collection.iterator();
        long start = System.nanoTime();
        while (itr.hasNext()) {
            tmp = itr.next();
            if (tmp == element) {
                long finish = System.nanoTime();
                long avTime = finish - start;
                System.out.println(avTime);
                return true;
            }
        }
        long finish = System.nanoTime();
        long avTime = finish - start;
        System.out.println(avTime);
        return false;
    }

    public void remove(List<Object> collection, Object element) {
        if (contains(collection, element) == true) {
            long start = System.nanoTime();
            collection.remove(element);
            long finish = System.nanoTime();
            long avTime = finish - start;
            System.out.println(avTime);
            System.out.println(collection);
        } else {
            System.out.println("Такого элемента нет в коллекции.");
        }
    }

    public void remove(Set<Object> collection, Object element) {
        if (contains(collection, element) == true) {
            long start = System.nanoTime();
            collection.remove(element);
            long finish = System.nanoTime();
            long avTime = finish - start;
            System.out.println(avTime);
            System.out.println(collection);
        } else {
            System.out.println("Такого элемента нет в коллекции.");
        }
    }
}

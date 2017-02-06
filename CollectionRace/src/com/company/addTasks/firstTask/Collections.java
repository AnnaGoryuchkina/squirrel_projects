package com.company.addTasks.firstTask;

import java.util.*;

/**
 * Created by AGoryuchkina on 11.01.2017.
 */
public class Collections<T> implements CollectionMethods{
    ArrayList<Integer> arrList = new ArrayList<Integer>();
    Random r = new Random();

    public void filling (){
    //    for (int i= 0; i< 10; i++){
    //        int el = arrList.add(i, r.nextInt(20);
    //        System.out.print(el + "");
    //    }
    }

    @Override
    public void collFilling(Collection<?> collection, Object chosenType) {
     //   for (int i= 0; i< 1000000; i++){
     //       boolean add = collection.add(Integer);
     //   }
    }

    @Override
    public void addFirst(Collection<?> collection, Object element) {
        Object firstElement = -1;
        if (collection.iterator().hasNext()){
            firstElement = collection.iterator().next();
        }

    }

    @Override
    public void contains(Collection<?> collection, Object element) {
        collection.contains(element);
    }

    @Override
    public void remove(Collection<?> collection, Object element) {
        collection.remove(element);
    }
}

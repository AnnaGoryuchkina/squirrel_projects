package com.company.addTasks.firstTask;

import java.util.Collection;

/**
 * Created by AGoryuchkina on 11.01.2017.
 */
public interface CollectionMethods {
    public abstract void collFilling(Collection<?> collection, Object chosenType);
    public abstract void addFirst(Collection<?> collection, Object element);
    public abstract void contains(Collection<?> collection, Object element);
    public abstract void remove(Collection<?> collection, Object element);
}

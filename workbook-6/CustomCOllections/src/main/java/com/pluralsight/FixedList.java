package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class FixedList <T>{

    List<T> items;
    int maxSize;

    public FixedList(int maxSize) {
        this.maxSize = maxSize;
        items = new ArrayList<>();
    }

    public boolean add(T item){
        if (items.size() >= maxSize)
            return false;
        else {
            items.add(item);
            return true;
        }
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<T> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "FixedList{ " +
                "items = " + items +
                ", maxSize = " + maxSize +
                " }";
    }
}

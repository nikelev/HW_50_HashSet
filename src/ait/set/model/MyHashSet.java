package ait.set.model;

import ait.set.interfaces.ISet;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet<E> implements ISet<E> {

    private LinkedList<E>[] hashSet;
    private int size;
    private int capacity;
    private double loadFactor;

    public MyHashSet(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        hashSet=new LinkedList[capacity];

    }

    public MyHashSet(int capacity) {
        this(capacity,0.75);
    }
    public MyHashSet( ) {
        this(16,0.75);
    }

    @Override
    public boolean add(E element) {
       if (size >=loadFactor*capacity){
           rebuildArray();
       }
       int index=getIndex(element);
       if ((hashSet[index]==null)){
           hashSet[index]=new LinkedList<>();
       }
       if (hashSet[index].contains(element)){
           return false;
       }
       hashSet[index].add(element);
       size++;
       return true;
    }

    private void rebuildArray() {
        capacity=capacity*2;
        LinkedList<E>[] newHashSet=new LinkedList[capacity];
        for (int i = 0; i < hashSet.length; i++) {
            if (hashSet[i]!=null){
                for (E e : hashSet[i]) {
                    int index=getIndex(e);
                    if (newHashSet[index]==null){
                        newHashSet[index]=new LinkedList<>();
                    }
                    newHashSet[index].add(e);
                }
            }
        }
    }

    private int getIndex(E element) {
        int hashcode=element.hashCode();
        hashcode=hashcode>=0?hashcode:-hashcode;
        return hashcode%capacity;
    }
    //O(1)
    @Override
    public boolean contains(E element) {
        int index=getIndex(element);
        if (hashSet[index]==null){
            return false;
        }
        boolean res=hashSet[index].remove(element);
        if (res){
            size--;
        }
        return res;
    }
//O(1)
    @Override
    public boolean remove(E element) {
        int index=getIndex(element);
        if (hashSet[index]==null){
            return false;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int totalCounter;
            int i;
            int j;
            @Override
            public boolean hasNext() {
                return totalCounter<size;
            }

            @Override
            public E next() {
                while (hashSet[i]==null||hashSet[i].isEmpty()){
                    i++;
                }
                E res=hashSet[i].get(j);
                totalCounter++;
                if (j<hashSet[i].size( )-1){
                    j++;
                }else {
                    i++;
                    j=0;
                }
                return res;
            }
        };
    }
}

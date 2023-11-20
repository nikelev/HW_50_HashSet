package ait.set;

import ait.set.interfaces.ISet;
import ait.set.model.MyHashSet;

public class MyHashSetAppl {
    public static void main(String[] args) {
        ISet<String>mySet=new MyHashSet<>();
        mySet.add("Boston");
        mySet.add("Atlanta");
        System.out.println(mySet.add("Chicago"));
        System.out.println(mySet.add("Chicago"));
        System.out.println(mySet.add("New York"));
        System.out.println(mySet.add("Detroit"));

        System.out.println("=============conteins================");
        System.out.println(mySet.contains("Chicago"));
        System.out.println(mySet.contains("Dallas"));

        System.out.println("=========remove=============");
        System.out.println(mySet.remove("Boston"));
        System.out.println(mySet.contains("Boston"));

        System.out.println("============iterator==================");
        for (String str : mySet) {
            System.out.println(str);
        }
    }
}

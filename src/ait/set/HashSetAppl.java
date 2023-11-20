package ait.set;

import ait.set.interfaces.ISet;
import ait.set.model.MyHashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetAppl {
    public static void main(String[] args) {
        Set<String> mySet=new HashSet<>();
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

        System.out.println(mySet.size());
    }
}

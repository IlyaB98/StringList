package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List list = new List(3);
        List list2 = new List(3);

        list2.add("String 1");
        list2.add("String 3");

        System.out.println(list.add("String 1"));
        System.out.println(list.add(1,"String 2"));
        System.out.println(list.set(1,"String 3"));
//        System.out.println(list.remove("String 3"));
//        System.out.println(list.remove(1));
        System.out.println(list.contains("String 2"));
        System.out.println(list.indexOf("String 1"));
        System.out.println(list.lastIndexOf("String 3"));
        System.out.println(list.get(0));
        System.out.println(list.equals(list2));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
//        list.clear();
        System.out.println(Arrays.toString(list.toArray()));

    }
}
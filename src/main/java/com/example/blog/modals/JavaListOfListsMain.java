package com.example.blog.modals;

import java.util.ArrayList;
import java.util.List;

public class JavaListOfListsMain {
    public static void main(String[] args) {
        List<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("Delhi");
        list1.add("Mumbai");
        listOfLists.add(list1);

        ArrayList<String> anotherList = new ArrayList<String>();

        anotherList.add("Beijing");
        anotherList.add("Shanghai");
        listOfLists.add(anotherList);

        listOfLists.forEach((list)  ->
                {
                    //list.forEach((city)->System.out.println(city));
                    System.out.println("list = " + list);
                }
        );
    }
}

package com.collection_test;

import java.util.Iterator;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray<Integer> myArray = new MyArray();
        for(int i = 0; i < 18; i++) {
            myArray.add(i);
        }
        System.out.println(myArray);
        myArray.remove(2);
        System.out.println(myArray);
        myArray.trimToSize();
        myArray.printMyArray();

        Iterator<Integer> iterator = myArray.iterator();
        while(iterator.hasNext()) {
            System.out.println("---->>>>" + iterator.next());
        }
    }
}

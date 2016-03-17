package com.map_test;

import java.util.Iterator;

public class MyMapTest {
    public static void main(String[] args) {
        MyMap<String, String> myMap = new MyMap<String, String>();
//        myMap.put(1, "Eugene");
//        myMap.put(2, "Oleg");//ключики - любые
//        System.out.println(myMap);
//        myMap.put(0, "Oleg_new_value");//должен перезатереть старое значение - Eugene, смотрите ключик 1 -> 8 строчка
//        System.out.println(myMap);
//        myMap.removeElement(1);
//        System.out.println(myMap);
        for (int i = 0; i <17 ; i++) {
            myMap.put("VV" + i, String.valueOf(i));
        }
        System.out.println(myMap);
        Iterator<String> iterator = myMap.iterator();

        while (iterator.hasNext()){
            System.out.println("=======>>>>" + iterator.next());
        }

        myMap.removeElement("VV2");
        //myMap.removeElement("VV10");

        myMap.setCursor(0);

        while (iterator.hasNext()){
            System.out.println("=======>>>>" + iterator.next());
        }



    }
}

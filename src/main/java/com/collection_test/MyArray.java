package com.collection_test;

import java.util.Arrays;
import java.util.Iterator;

public class MyArray<T extends Number> implements Iterable<T>, Iterator<T> {
    private final static int CAPACITY = 10;

    //массив для сохранения данных = пока-что условимся, что будем сохранять только
    //целочисленные значения
    private T mas[];

    //указывает актуальное положение в массиве - сохраняет позицию последнего элемента + 1
    private int currentActualPosition;

    //необходимо определить переменную для курсора - итератора, то-есть
    //для реализации логики проверки "есть ли следующий элемент" -> смотрите метод
    // hasNext - формируем нашу переменную/параметр/индекс - int cursor = 0
    // (указывает пока-что на первый элемент массива);
    private int cursor;

    public MyArray(T[] mas) {
        this.mas = mas;
    }

    public MyArray() {
        mas = (T[]) new Number[CAPACITY];
        currentActualPosition = 0;
        cursor = 0;
    }

    public void add(T newElement) {
        if (currentActualPosition >= mas.length) {
            mas = Arrays.copyOf(mas, mas.length + CAPACITY);
        }
        mas[currentActualPosition++] = newElement;

//        if(currentActualPosition >=0 && currentActualPosition < mas.length) {//место для сохранения нового элемента у нас ест
//            mas[currentActualPosition++] = newElement;
//        } else {
//            Arrays.copyOf(mas, mas.length + CAPACITY);
//            mas[currentActualPosition++] = newElement;
//        }
    }

    public void remove(int index) {
        //определяем "хвост" - количество элементов, которые нужно скопировать
        // [количество элементов для копирования] = количеству элементов,
        // стоящих/находящихся за позицией удаляемого элемента
        int copyElementSize = mas.length - index - 1;
        //перезатирание элемента, находящегося на позиции index - путем сдвига влево (на одну позицию)
        System.arraycopy(mas, index + 1, mas, index, copyElementSize);
        mas[mas.length - 1] = null;
        currentActualPosition--;
    }

    public void trimToSize() {
        mas = Arrays.copyOf(mas, currentActualPosition);
    }


    public T getMin() {
        T min = mas[0];

        for (int i = 1; i < mas.length; i++) {
            if (mas[i].doubleValue() < min.doubleValue()) {
                min = mas[i];
            }
        }
        return min;
    }

    @Override
    public String toString() {
        //выводит значения массива
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < currentActualPosition; i++) {
            result.append(mas[i] + ", ");
        }
        result.append("]");
        return result.toString();

    }

    public void printMyArray() {
        System.out.println(Arrays.toString(mas));
    }

    public Iterator<T> iterator() {
        return this;
    }

    public boolean hasNext() {
        return cursor < currentActualPosition;
        //на текущий момент курсор не добежал до конца нашего массива
    }

    public T next() {
        return mas[cursor++];
    }

    public void remove() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArray<?> myArray = (MyArray<?>) o;

        if (currentActualPosition != myArray.currentActualPosition) return false;
        if (cursor != myArray.cursor) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(mas, myArray.mas);

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(mas);
        result = 31 * result + currentActualPosition;
        result = 31 * result + cursor;
        return result;
    }
}

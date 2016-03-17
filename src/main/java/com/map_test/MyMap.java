package com.map_test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class MyMap<K, V> implements Iterator<V>, Iterable<V> {

    private static final int CAPACITY = 16;


    public static class MyEntry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;
        private MyEntry<K, V> nextEntry;//ссылка на следующий элемент(Олег -> Женя)
        private int hash;

        public MyEntry(K key, V value, MyEntry<K, V> nextEntry, int hash) {
            this.key = key;
            this.value = value;
            this.nextEntry = nextEntry;
            this.hash = hash;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public MyEntry<K, V> getNextEntry() {
            return nextEntry;
        }

        public void setNextEntry(MyEntry<K, V> nextEntry) {
            this.nextEntry = nextEntry;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            this.value = value;
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyEntry<?, ?> myEntry = (MyEntry<?, ?>) o;

            if (hash != myEntry.hash) return false;
            if (key != null ? !key.equals(myEntry.key) : myEntry.key != null) return false;
            if (value != null ? !value.equals(myEntry.value) : myEntry.value != null) return false;
            return !(nextEntry != null ? !nextEntry.equals(myEntry.nextEntry) : myEntry.nextEntry != null);

        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            result = 31 * result + (nextEntry != null ? nextEntry.hashCode() : 0);
            result = 31 * result + hash;
            return result;
        }

        @Override
        public String toString() {
            return "MyEntry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", nextEntry=" + nextEntry +
                    ", hash=" + hash +
                    '}';
        }
    }



    private MyEntry<K, V> elements[];
    private int cursor = 0;
    private MyEntry<K, V> cursorElement;

    public MyMap(MyEntry<K, V>[] elements) {
        this.elements = elements;
    }

    public MyMap() {
        elements = new MyEntry[CAPACITY];
    }

    public void put(K key, V value) {
        if (key != null) {
            int newPositionHash = hash(key);
            int index = indexFor(newPositionHash);
            if (index >= elements.length) {
                elements = Arrays.copyOf(elements, elements.length + CAPACITY);
            }
            System.out.println("index = " + index);
            MyEntry<K, V> element = elements[index];
            if (element != null && key.equals(element.key)
                    && (newPositionHash == element.hash)) {
                element.setValue(value);
            } else {
                createNewMyEntry(value, key, newPositionHash, element, index);
            }
        }
    }

    public void removeElement(K key) {
        int index = indexFor(hash(key));
        if (elements[index].nextEntry != null) {
            MyEntry<K, V> element = elements[index];
            MyEntry<K, V> beforeElement = null;

            while (!element.key.equals(key)) {
                beforeElement = element;
                element = element.nextEntry;
            }
            if(beforeElement == null){

                elements[index]=element.nextEntry;

            } else if (element.nextEntry != null) {

                beforeElement.nextEntry = element.nextEntry;

            } else beforeElement.nextEntry = null;

        } else elements[index] = null;
    }

    private void createNewMyEntry(V value, K key, int newPositionHash,
                                  MyEntry<K, V> element, int index) {
        MyEntry myEntry = new MyEntry(key, value, element, newPositionHash);
        elements[index] = myEntry;
    }


    private int indexFor(int newPositionHash) {
        return newPositionHash & (elements.length - 1);
    }

    private int hash(K key) {
        int h = key.hashCode();
        System.out.println("1) ->>> " + Integer.toBinaryString(h));
        h ^= (h >>> 20) ^ (h >>> 12);
        System.out.println("2) ->>> " + Integer.toBinaryString(h));
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public Iterator<V> iterator() {
        return this;
    }

    public boolean hasNext() {
        return cursor < elements.length;
    }

    public V next() {
        if(elements[cursor].nextEntry == null) {
            if(cursor < elements.length - 1) {
                cursorElement = elements[cursor + 1];
            }
            return elements[cursor++].value;
        } else {

            V permanentValue = cursorElement.value;
            cursorElement = cursorElement.nextEntry;
            if(cursorElement == null){
                cursor++;
            }
            return permanentValue;
        }



    }

    public void remove() {

    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    @Override
    public String toString() {
        return "MyMap{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}

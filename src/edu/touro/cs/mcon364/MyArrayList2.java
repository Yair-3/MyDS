package edu.touro.cs.mcon364;

import java.util.*;

public class MyArrayList2 implements List<String>, Iterable<String> {

    private String[] backingStore = new String[10];
    private int ip = 0; // insertion point
    @Override
    public int size() {
        return ip;
    }

    @Override
    public boolean isEmpty() {
        {
            return ip == 0;
        }

    }
    @Override
    public boolean contains(Object o) {
        if (o instanceof String || o == null ){
            for (int i = 0; i < ip; i++){
                if (Objects.equals(backingStore[i], o)){
                    return true;
                }
            }}
        return false;
    }


    @Override
    public boolean add(String s) {
        if (ip >= backingStore.length){
            growBackingStore();
        }
        backingStore[ip] = s;
        ip++;
        return true;

    }
    private void growBackingStore() {
        String[] newBs = new String[2 * backingStore.length + 1];
        System.arraycopy(backingStore, 0, newBs, 0, backingStore.length);
        backingStore = newBs;

    }
    @Override
    public void clear() {
        backingStore = new String[10];
        ip = 0;
    }

    @Override
    public String get(int index) {
        throwOutOfBoundsException(index);
        return backingStore[index];
    }

    @Override
    public String set(int index, String element) {
        String oldElement;
        throwOutOfBoundsException(index);
        oldElement = backingStore[index];
        backingStore[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, String element) {
        throwOutOfBoundsException(index);
        if (this.ip + 1 - index >= 0)
            System.arraycopy(backingStore, index, backingStore, index + 1, this.ip + 1 - index);
        backingStore[index] = element;
        this.ip++;

    }

    @Override
    public String remove(int index) {
        String removed;
        throwOutOfBoundsException(index);
        removed = backingStore[index];
        if (this.ip - index >= 0)
            System.arraycopy(backingStore, index + 1, backingStore, index, this.ip - index);
        this.ip--;
        return removed;
    }

    private void throwOutOfBoundsException(int index){
        if (index < 0 || index >= ip)
        {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
    }
    @Override
    public Iterator<String> iterator() {

        return new CustomIterator();
    }
    public class CustomIterator implements Iterator<String> {

        int preIndex = 0;

        @Override
        public boolean hasNext() {
            return preIndex < ip;
        }

        @Override
        public String next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return backingStore[preIndex++];
        }
    }

    @Override
    public Object[] toArray() {
        int counter = 0;
        String [] array = new String[ip];
        for (String a : backingStore){
            if (counter < ip){
                array[counter] = a;
                counter++;
            }
        }
        return array;
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof String || o == null) {
            for (int i = 0; i < ip; i++){
                if (Objects.equals(backingStore[i], o)){
                    int index = indexOf(o);
                    remove(index);
                    return true;
                }
            }

        } return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] newArray = c.toArray();
        boolean contains;
        for (Object o : newArray) {
            contains = contains(o);
            if (!contains) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean addAll(Collection<? extends String> c) {
        Object [] newArray = c.toArray();
        for (Object o : newArray) {
            add((String) o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        Object[] newArray = c.toArray();
        for (Object o : newArray) {
            add(index, (String) o);
            index++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            this.remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < ip; i++) {
            if (!c.contains(backingStore[i])){
                remove(backingStore[i]);
                i -= 1;
            }
        }
        return true;
    }

    @Override
    public int indexOf(Object o)
    {
        int index;
        for (int i = 0; i < backingStore.length; i++) {
            if (backingStore[i] == o) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index;
        for (int i = ip; i > 0; i--) {
            if (backingStore[i] == o) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }

    public void display() {
        System.out.print("Displaying list : ");
        for (int i = 0; i < ip; i++) {
            System.out.print(backingStore[i] + " ");
        }
    }
}

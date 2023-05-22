package edu.touro.cs.mcon364;

import java.util.*;

public class MyHashSet implements Set<String> {

    List<String>[] buckets;
    private int capacity;
    private double load_factor;
    int numElements;
    private int element_count_for_iterator;


    public MyHashSet() {
        this(16, 0.75);

    }

    public MyHashSet(int capacity, double factor) {
        if (capacity < 0 || factor < 0) {
            throw new IllegalArgumentException("Hash-Set cannot accept negative Args");
        }
        this.capacity = capacity;
        this.load_factor = factor;
        buckets = new List[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new ArrayList<>();
        }

    }

    public MyHashSet(int capacity) {
        this(capacity, .75);
    }

    public double current_load_factor() { // method was made public strictly for testing purposes
        return (double) numElements / buckets.length;
    }

    @Override
    public boolean add(String s) {
        if (current_load_factor() > load_factor) {
            resize(capacity * 2 + 1);
        }
        int hashval;
        if (s != null) {
            hashval = s.hashCode();
            hashval = hashval & 0x7FFFFFFF;
            hashval = hashval % capacity;
        } else {
            hashval = 0;
        }
        buckets[hashval].add(s);
        numElements++;
        element_count_for_iterator++;
        return true;
    }

    private void resize(int newSize) {
        List<String>[] newArray = new ArrayList[newSize];
        for (int i = 0; i < newSize; i++) {
            newArray[i] = new ArrayList<>();
        }
        for (String s : this) {
            int hashval = s.hashCode();
            hashval = hashval & 0x7FFFFFFF;
            hashval = hashval % capacity;
            newArray[hashval].add(s);
        }
        buckets = newArray;
        capacity = newSize;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return numElements <= 0;
    }

    @Override
    public boolean contains(Object o) {
        return buckets[findHashval(o)].contains(o);
    }

    public Iterator<String> iterator() {
        return new CustomIterator();
    }

    public class CustomIterator implements Iterator<String> {
        int bucket_pointer = 0;
        int main_list_index = 0;
        String element;

        @Override
        public boolean hasNext() {
            return element_count_for_iterator >= 1;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (buckets[main_list_index].size() > 0) {
                element = buckets[main_list_index].get(bucket_pointer);
                bucket_pointer++;
                element_count_for_iterator--;
            } else element = null;

            if (bucket_pointer == buckets[main_list_index].size()) {
                main_list_index++;
                bucket_pointer = 0;
            }
            if (element == null) {
                next();
            }
            return element;
        }

    }

    @Override
    public Object[] toArray() {
        String[] newArray = new String[numElements];
        Iterator<String> itr = iterator();
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = itr.next();
        }
        return newArray;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        }
        buckets[findHashval(o)].remove(o);
        numElements--;
        element_count_for_iterator--;
        return true;
    }

    @Override
    public void clear() {
        for (List<String> bucket : buckets) {
            bucket.clear();
        }
        numElements = 0;
    }

    private int findHashval(Object o) {
        int hashval = o.hashCode();
        hashval = hashval & 0x7FFFFFFF;
        return hashval % buckets.length;
    }

    @Override
    public Object clone() {
        return null;
    }


    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }
}

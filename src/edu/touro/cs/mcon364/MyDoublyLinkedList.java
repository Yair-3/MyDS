package edu.touro.cs.mcon364;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList extends AbstractSequentialList<String> {
    private Node head = new Node(null, null, null);
    private int size = 0;
    private static class Node{
        private String data;
        private Node prev, next;

        Node(String d, Node p, Node next){
            this.data = d;
            this.prev = p;
            this.next = next;
        }
    }
    @Override
    public ListIterator<String> listIterator(int index) {
        return new MyLIterator(index);
    }

    private class MyLIterator implements  ListIterator<String>{

        MyLIterator() // no-arg c-tor
        {
            this(0); // telescoping c-tor
        }
        MyLIterator(int index)
        {
            for (int counter = 0; counter < index; counter++)
            {
                pointer = pointer.next;
            }
            nextIndex = index;
        }
        private int nextIndex;
        private Node last_returned_node;
        private Node pointer = head;
        private boolean next_prev_called;
        @Override
        public boolean hasNext() {
            return pointer.next!= null;
        }

        @Override
        public String next() {
            next_prev_called = false;
            if (! hasNext()){
                throw new NoSuchElementException();
            }
            pointer = pointer.next;
            nextIndex++;
            last_returned_node = pointer;
            return pointer.data;
        }

        @Override
        public boolean hasPrevious() {
            return pointer.prev!= null;
        }

        @Override
        public String previous() {
            next_prev_called = false;
            if (! hasPrevious()){
                throw new NoSuchElementException();
            }
            pointer.next = pointer;
            pointer = pointer.prev;
            nextIndex--;
            last_returned_node = pointer;
            return pointer.data;

        }

        @Override
        public int nextIndex() {
            if (pointer.next == null){
                return size;
            }
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            if (pointer.prev == null){
                return -1;
            }
            return nextIndex -1;
        }

        @Override
        public void remove() {
            if (next_prev_called){
                throw new IllegalStateException();
            }
            --size;
            last_returned_node.prev.next = last_returned_node.next;
            next_prev_called = true;
            nextIndex--;
        }

        @Override
        public void set(String s) {
            if (next_prev_called){
                throw new IllegalStateException();
            }
            next_prev_called = true;
            last_returned_node.next.data = s;
        }

        @Override
        public void add(String s) {
            next_prev_called = true;
            ++size;
            Node n = new Node(s, pointer, pointer.next);
            pointer.next = n;
            if (n.next != null)
                n.next.prev=n;
        }
        }
    @Override
    public int size() {
        return size;
    }
}

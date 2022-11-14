package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Test;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyDoublyLinkedListTest {

    MyDoublyLinkedList dll = new MyDoublyLinkedList();
    ListIterator<String> it = dll.listIterator(0);

    @Test
    void size() {
        dll.add("D");
        dll.add("E");
        dll.add("E");
        dll.add("E");
        assertEquals(4, dll.size());
    }


    @Test
    void listIteratorNext() {
        it.add("x");
        it.add("y");
        it.add("z");
        it.next();
        assertEquals("y", it.next());
    }

    @Test
    void nextExceptionTest(){
        dll.add("a");
        dll.add("b");
        it.next();
        it.next();

        try{
            it.next();
        }
        catch (NoSuchElementException e) {
            return;
        }
        fail("The exception didn't throw");

    }

    @Test
    void listIteratorHasNext() {
        assertFalse(it.hasNext());
        it.add("a");
        assertTrue(it.hasNext());
        it.add("b");
        assertEquals("b", it.next());
    }

    @Test
    void listIteratorPrev() {
        dll.add("a");
        dll.add("b");
        it.next();
        assertEquals("a", it.previous());

    }

    @Test
    void prevExceptionTest(){
        try{
            it.previous();
        }
        catch (NoSuchElementException e) {
            return;
        }
        fail("The exception didn't throw");

    }

    @Test
    void listIteratorHasPrev() {
        assertFalse(it.hasPrevious());
        it.add("a");
        it.next();
        it.previous();
        assertFalse(it.hasPrevious());

    }

    @Test
    void nextIndex() {
        dll.add("1");
        dll.add("2");
        assertEquals(0, it.nextIndex());
        it.next();
        assertEquals(1, it.nextIndex());
        it.next();
        assertEquals(dll.size(), it.nextIndex());       //if no next index, nextIndex() == size
    }

    @Test
    void previousIndex() {
        assertEquals(-1, it.previousIndex());       //-1 if beginning of index
        dll.add("1");
        dll.add("2");
        it.next();
        assertEquals(0, it.previousIndex());
        it.next();
        assertEquals(1, it.previousIndex());
    }

    @Test
    void set() {
        dll.add("a");
        dll.add("b");
        assertEquals("b", dll.get(1));
        it.next();
        it.set("java");
        assertEquals("java", dll.get(1));
    }

    @Test
    void setExceptionTest() {
        dll.add("a");
        dll.add("b");
        it.next();
        it.add("c");
        assertEquals("c", dll.get(1));

        try {
            it.set("Python");
        } catch (IllegalStateException e) {
            return;
        }
        fail("The exception didn't throw");
    }

    @Test
    void add() {
        it.add("g");
        assertEquals("g", dll.get(0));
        dll.add("a");
        dll.add("b");
        it.next();          //pointer is at index(1)
        it.add("java");
        assertEquals("a", dll.get(2));

    }

    @Test
    void remove() {
        dll.add("a");
        dll.add("b");
        dll.add("c");
        it.next();
        it.remove();
        assertEquals("b", dll.get(0));
    }

    @Test
    void removeExceptionTest(){
        dll.add("a");
        dll.add("b");
        it.next();
        it.previous();
        it.next();
        it.remove();

        try{
            it.remove();
        }
        catch (IllegalStateException e) {
            return;
        }
        fail("The exception didn't throw");

    }



}




package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    MyArrayList2 newArraylist = new MyArrayList2();

    @Test
    void add(){
        newArraylist.add("Yair");
        newArraylist.add("Kimmel");
        assertEquals(2, newArraylist.size());
    }

    @Test
    void size(){
        newArraylist.add("Yair");
        newArraylist.add("Kimmel");
        assertEquals(2, newArraylist.size());

    }
    @Test
    void isEmpty(){
        assertTrue(newArraylist.isEmpty());

    }
    @Test
    void contains(){
        newArraylist.add("hello");
        assertTrue(newArraylist.contains("hello"));


    }
    @Test
    void clear(){
        newArraylist.add("Yair");
        newArraylist.add("Kimmel");
        assertEquals(2, newArraylist.size());
        newArraylist.clear();
        assertEquals(0, newArraylist.size());

    }
    @Test
    void get(){
        newArraylist.add("Yair");
        newArraylist.add("Kimmel");
        assertEquals("Yair", newArraylist.get(1));
        assertEquals("Kimmel", newArraylist.get(0));

    }
    @Test
    void set(){
        newArraylist.add("Yair");
        newArraylist.add("Kimmel");
        newArraylist.add("Yair");
        newArraylist.set(2, "cheese_sticks");
        assertEquals("cheese_sticks", newArraylist.get(2));



    }
    @Test
    void setExceptionTest(){
        newArraylist.add("a");
        try{
            newArraylist.set(5, "peanuts");}
        catch (IndexOutOfBoundsException e) {
            return;
        }
        fail("The exception didn't throw");

    }
    @Test
    void addTwo(){
        newArraylist.add("Jonny"); // 0
        newArraylist.add("James"); // 1
        newArraylist.add("Jackson"); // 2
        newArraylist.add(1, "Justin");
        assertEquals("Jackson", newArraylist.get(3));
        assertEquals("James", newArraylist.get(2));

    }
    @Test
    void addTwoExceptionTest(){
        newArraylist.add("awkward");

        try{
            newArraylist.add(5, "cheese_sticks");}
        catch (IndexOutOfBoundsException e) {
            return;
        }
        fail("The exception didn't throw");

    }
    @Test
    void remove(){
        newArraylist.add("Jonny"); // 0
        newArraylist.add("James"); // 1
        newArraylist.add("Jackson"); // 2
        newArraylist.remove(0);
        assertEquals("James", newArraylist.get(0));//test

    }

    @Test
    void indexOf(){
        newArraylist.add("a");
        newArraylist.add("b");
        newArraylist.add("c");
        newArraylist.add("d");
        newArraylist.add("e");
        int s = newArraylist.indexOf("e");
        assertEquals(4, s);
    }
    @Test
    void indexOfExceptionTester(){
        newArraylist.add("awkward");

        try{
            newArraylist.indexOf("cheesesticks");}
        catch (NullPointerException e) {
            return;
        }
        fail("The exception didn't throw");

    }

    @Test
    void lastIndexOf(){
        newArraylist.add("a");
        newArraylist.add("e");
        newArraylist.add("e");
        newArraylist.add("d");
        newArraylist.add("e");
        int s = newArraylist.lastIndexOf("e");
        assertEquals(4, s);
    }


    @Test
    void iterator() {
        newArraylist.add("1"); newArraylist.add("2");
        int i = 1;
        // for each using iterator
        for (Iterator<String> iterator = newArraylist.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            assertEquals(i++ + "", s);
        }
    }


    @Test
    void toArray(){
        newArraylist.add("a");
        newArraylist.add("b");
        newArraylist.add("c");
        newArraylist.add("d");

        Object[] arr = newArraylist.toArray();
        assertEquals(newArraylist.get(1), arr[1]);
        assertEquals(newArraylist.get(2), arr[2]);
        assertEquals(newArraylist.get(3), arr[3]);
    }

    @Test
    void removeObject(){
        newArraylist.add("Java");
        newArraylist.add("Python");
        newArraylist.add("CSS");
        newArraylist.add("C++");
        newArraylist.add("SQL");
        newArraylist.add("Ruby");
        newArraylist.remove("SQL");
        assertEquals("Ruby", newArraylist.get(4));
    }

    @Test
    void containsAll(){
        boolean containsAll;
        ArrayList<String> array = new ArrayList<>();  //?xceptions
        array.add("Yair");
        array.add("Kimmel");
        array.add("x");
        newArraylist.add("Yair");
        newArraylist.add("Kimmel");
        newArraylist.add("Joe");
        newArraylist.add("Matthew");
        containsAll = newArraylist.containsAll(array);
        assertFalse(containsAll);

    }

    @Test
    void addAll(){
        ArrayList<String> array = new ArrayList<>();
        newArraylist.add("Yair");
        newArraylist.add("Kimmel");
        newArraylist.add("Joe");
        newArraylist.add("Matthew");
        //filling up array 2
        array.add("Java");
        array.add("C");
        array.add("Python");
        array.add("SQL");
        array.add("Ruby");
        newArraylist.addAll(array);
        assertEquals("Python", newArraylist.get(6));
    }

    @Test
    void addAllIndex(){
        ArrayList<String> array = new ArrayList<>();
        newArraylist.add("Yair");
        newArraylist.add("Kimmel");
        newArraylist.add("Mark");
        newArraylist.add("5");
        newArraylist.add("6");
        array.add("Yair Mark");
        array.add("Joe Shmoe");
        newArraylist.addAll(3, array);
        boolean containsAll = newArraylist.containsAll(array);
        assertEquals("5", newArraylist.get(5));
        assertEquals("Yair Mark", newArraylist.get(3));
        assertTrue(containsAll);
    }
    @Test
    void addAllIndexExceptionTest(){
        ArrayList<String> array = new ArrayList<>();
        newArraylist.add("a");
        newArraylist.add("b");
        array.add("Java");
        array.add("SQL");

        try{
            newArraylist.addAll(8, array);}
        catch (IndexOutOfBoundsException e) {
            return;
        }
        fail("The exception didn't throw");}

    @Test
    void removeAll(){

        ArrayList<String> array = new ArrayList<>();
        newArraylist.add("a");
        newArraylist.add("b");
        newArraylist.add("c");
        newArraylist.add("d");
        newArraylist.add("b");
        newArraylist.add("e");
        array.add("a");
        array.add("b");
        array.add("elefant");
        newArraylist.removeAll(array);
        assertEquals("c", newArraylist.get(0));
        assertEquals("e", newArraylist.get(3));
    }

    @Test
    void retainAll() {
        LinkedList<String> linkedList = new LinkedList<String>();
        newArraylist.add("Yair");
        newArraylist.add("Kimmel");
        newArraylist.add("Joe");
        newArraylist.add("Matthew");
        linkedList.add("Joe");
        linkedList.add("Matthew");
        newArraylist.retainAll(linkedList);
        assertEquals("Joe", newArraylist.get(0));
    }

}
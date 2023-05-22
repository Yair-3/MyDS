package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetTest {
    MyHashSet hash = new MyHashSet();
    @Test
    void add() {
        hash.add("Aa"); // Same HashCode
        hash.add(null); // Same HashCode
        hash.add("c");
        assertEquals(3, hash.size());

    }
    @Test
    void remove(){
        hash.add("a");
        hash.add("b");
        hash.add("c");
        hash.remove("c");
        assertFalse(hash.remove("f"));
        assertEquals(2, hash.size());
    }
    @Test
    void contains(){
        hash.add("a");
        hash.add("b");
        hash.add("c");
        boolean contains_c = hash.contains("c");
        boolean contains_f = hash.contains("f");
        assertTrue(contains_c); // tests that c was added
        assertFalse(contains_f);
    }

    @Test
    void Iterator(){
        hash.add("Aa");
        hash.add("CDE");
        hash.add("Haj");
        hash.add("LMN");
        hash.add("QTU");
        hash.add("ADR");
        hash.add("g");
        hash.add("h");
        for (String s : hash) {
            System.out.println(s);
        }
    }
    @Test
    void resize() {
        hash.add("A");
        hash.add("B");
        hash.add("C");
        hash.add("E");
        hash.add("F");
        hash.add("G");
        hash.add("H");
        hash.add("I");
        hash.add("j");
        hash.add("K");
        hash.add("L");
        hash.add("M");
        hash.add("N"); // element 13. List MUST BE resized already.
        hash.add("O");
        hash.add("P");
        hash.add("Q"); // element 16 LF must be 50%. Let's check
        assertEquals(.5, hash.current_load_factor());

    }

    @Test
    void toArray(){
        hash.add("ee");
        hash.add("aa");
        hash.add("bb");
        hash.add("cc");
        Object[] joe = hash.toArray();
        int i = 0;
        for (Object o : joe) {
            System.out.println(o);
            assertEquals(o + "", joe[i] );
            i++;
        }

    }

    @Test
    void clear(){
        hash.add("ee");
        hash.add("aa");
        hash.add("bb");
        hash.add("cc");
        hash.clear();
        assertEquals(0, hash.size());
    }
    @Test
    void isEmpty(){
        boolean is_it_empty;
        hash.add("ee");
        hash.add("aa");
        hash.add("bb");
        hash.add("cc");
        hash.remove("bb");
        is_it_empty = hash.isEmpty();
        assertFalse(is_it_empty);
    }
    @Test
    void hasNext(){
        Iterator<String> itr = hash.iterator();
        hash.add("ee");
        hash.add("aa");
        hash.add("bb");
        itr.next();
        itr.next();
        itr.next();
        assertFalse(itr.hasNext());
        hash.add("a");
        assertTrue(itr.hasNext());
    }
    @Test
    void next(){
        Iterator<String> itr = hash.iterator();
        hash.add("G");
        hash.add("H");
        hash.add("I"); //since we are adding 3 letters with consecutive HashCodes/ASCII values we can predict/confirm the behavior of the Itr.
        itr.next();
        assertEquals("H", itr.next());

    }
}
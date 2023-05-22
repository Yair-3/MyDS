package edu.touro.cs.mcon364;

import edu.touro.cs.mcon364.comparators.ReverseAlphabetComparator;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriorityQueueTest {

    PriorityQueue<Integer> integers = new PriorityQueue<>();

    PriorityQueue<String> strings = new PriorityQueue<>(new ReverseAlphabetComparator());

    @Test
    void add() {
        integers.add(3);
        integers.add(5);
        integers.add(1);
        integers.add(2);
        integers.add(4);
        assertEquals(5, integers.size());
        integers.remove();
        assertEquals(2, integers.peek());

    }

    @Test
    void remove() {
        integers.add(3);
        integers.add(4);
        integers.add(10);
        integers.add(1);
        integers.add(10);
        integers.add(6);

        assertEquals(1, integers.remove());
        assertEquals(3, integers.remove());
        assertEquals(4, integers.remove());
        assertEquals(3, integers.size());
        assertEquals(6, integers.remove());
        assertEquals(10, integers.remove());
        assertEquals(10, integers.remove());
        assertThrows(NoSuchElementException.class,  () -> integers.remove());



    }

    @Test
    void poll() {
        integers.add(3);
        integers.add(4);
        integers.add(10);
        integers.add(1);
        integers.add(10);
        integers.add(6);

        assertEquals(1, integers.poll());
        assertEquals(3, integers.poll());
        assertEquals(4, integers.poll());
        assertEquals(6, integers.poll());
        assertEquals(10, integers.poll());
        assertEquals(10, integers.poll());



    }

    @Test
    void offer() {
        integers.offer(3);
        integers.offer(5);
        integers.offer(1);
        integers.offer(2);
        integers.offer(4);
        integers.remove();
        assertEquals(2, integers.peek());

    }

    @Test
    void peek() {
        integers.add(4);
        integers.add(10);
        integers.add(3);
        integers.add(10);
        integers.add(6);

        assertEquals(3, integers.peek());
        integers.remove();
        assertEquals(4, integers.peek());
        integers.remove();
        assertEquals(6, integers.peek());
        integers.remove();
        assertEquals(10, integers.peek());

    }
    @Test
    void element() throws NoSuchElementException{
        integers.add(4);
        integers.add(10);
        integers.add(3);
        integers.add(10);
        integers.add(6);

        assertEquals(3, integers.element());
        integers.remove();
        assertEquals(4, integers.element());
        integers.remove();
        assertEquals(6, integers.element());
        integers.remove();
        assertEquals(10, integers.element());
        integers.remove();
        integers.remove();
        assertThrows(NoSuchElementException.class,  () -> integers.element());



    }

    @Test
    void comparator_as_argument(){
        strings.add("BB");
        strings.add("AA");
        strings.add("DD");
        strings.add("CC");

        assertEquals("DD", strings.peek()); // The constructor will make the priority that
                                                    // the farthest down in the ABCs gets removed first
    }

}

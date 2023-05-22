package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomSerializationTest {
    @Test
    void regularComparator() throws IOException, ClassNotFoundException {
        PriorityQueue<Integer> integer = new PriorityQueue<>();

        FileOutputStream fos;
        fos = new FileOutputStream("save_the_queue.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        integer.add(1);
        integer.add(8);
        integer.add(4);
        integer.add(10);

        oos.writeInt(integer.size());
        oos.writeObject(integer);

        integer.remove();
        integer.remove();
        integer.remove();

        FileInputStream fis;
        fis = new FileInputStream("save_the_queue.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        integer.setSize(ois.readInt());

        integer  = (PriorityQueue<Integer>) ois.readObject();

        assertEquals(4, integer.size());
        assertEquals(1, integer.peek());
        integer.remove();
        assertEquals(4, integer.peek());

    }
    @Test
    void ReverseComparator() throws IOException, ClassNotFoundException {
        Comparator<Integer> reverseComparator = Comparator.reverseOrder();
        PriorityQueue<Integer> integer = new PriorityQueue<>(reverseComparator);

        FileOutputStream fos;
            fos = new FileOutputStream("save_the_queue");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            integer.add(5);
            integer.add(8);
            integer.add(4);
            integer.add(1);
            integer.add(3);

            oos.writeInt(integer.size());
            oos.writeObject(integer);


        integer.remove();
        integer.remove();
        integer.remove();
        integer.remove();
        integer.remove();

        assertEquals(0, integer.size());


        FileInputStream fis;
            fis = new FileInputStream("save_the_queue");
            ObjectInputStream ois = new ObjectInputStream(fis);
            integer.setSize(ois.readInt());
            integer = (PriorityQueue<Integer>) ois.readObject();


        assertEquals(5, integer.size());
        assertEquals(8, integer.peek());
        integer.remove();
        integer.add(2);
        assertEquals(5, integer.peek());


    }

}


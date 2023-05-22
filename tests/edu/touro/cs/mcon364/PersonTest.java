package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person one = new Person();
    Person two = new Person();
    Person three = new Person();
    Person four = new Person();
    Person five = new Person();
    Person six = new Person();
    Person seven = new Person();
    Person eight = new Person();
    Person nine = new Person();
    Person ten = new Person();
    Person a = new Person("Last Name", "First Name", true,  (short) 2000);
    Person b = new Person("Last Name", "First Name", true,  (short) 2000);
    Person c = new Person("Last Name", "First Name", true,  (short) 1998);

    @Test
    void testEquals() {
        // test that person one and person two are not equal
        // test that person a and b are in fact the same
        // test that person a and c are in fact not the same
        boolean areTheyEqual1 = one.equals(two);
        boolean areTheyEqual2 = a.equals(b);
        boolean areTheyEqual3 = a.equals(c);
        assertFalse(areTheyEqual1);
        assertTrue(areTheyEqual2);
        assertFalse(areTheyEqual3);
    }
    @Test
    void testHashSet(){
        HashSet<Person> people = new HashSet<>();
        people.add(one);
        people.add(two);
        people.add(three);
        people.add(four);
        people.add(five);
        people.add(six);
        people.add(seven);
        people.add(eight);
        people.add(nine);
        people.add(ten);

        // confirm they were all added to HashSet People
        int size = people.size();
        assertEquals(10, size);
    }
    @Test
    void HashIterator(){
        HashSet<Person> people = new HashSet<>();
        people.add(one);
        people.add(two);
        people.add(three);
        people.add(four);
        people.add(five);
        people.add(six);
        people.add(seven);
        people.add(eight);
        people.add(nine);
        people.add(ten);
        Iterator<Person> it1 = people.iterator();
        // proove the HashSet is out of the insertion order
        // the odds of the first 4 Persons in the insertion order matching up with the random order
        // of the Iterator is highly unlikely-that is why I only tested 4.
        Person firstPerson = it1.next(); // gets the first Person from the Iterator
        Person secondPerson = it1.next();
        Person thirdPerson = it1.next();
        Person fourthPerson = it1.next();
        boolean areTheyEqual1 = one.equals(firstPerson); // tests if the insertion order is the same as the iterator order for P1
        boolean areTheyEqual2 = two.equals(secondPerson);
        boolean areTheyEqual3 = three.equals(thirdPerson);
        boolean areTheyEqual4 = four.equals(fourthPerson);
        // All four conditions below need to be true in order to confirm the order is the same.
        boolean firstFour = areTheyEqual1 && areTheyEqual2 && areTheyEqual3 && areTheyEqual4;
        assertFalse(firstFour);




    }
    @Test
    void hashCodeTest(){
    Person p1 = new Person("Kimmel", "Yair",true, (short) 2001);
    Person p2 = new Person("Kimmel", "Yair",true, (short) 2001);
    Person p3 = new Person("Kimmel", "Dovi",true, (short) 2001);
    assertEquals(p1.hashCode(), p2.hashCode());
    assertNotEquals(p1.hashCode(), p3.hashCode());
    }

    @Test
    void stringTest(){
    Person p1 = new Person("Kimmel", "Yair",true, (short) 2001);
    assertEquals("First Name: Yair" +
            "\nLast Name: Kimmel" +
            "\nYear of Birth: 2001" +
            "\nGender: Male", p1.toString());

    }
}
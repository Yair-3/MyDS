package edu.touro.cs.mcon364;

import java.util.Objects;
import java.util.Random;

public class Person {
    String fname, lname;
    boolean isMale;
    short yearOfBirth;
    // Arg c-tor
    public Person(String last, String first, boolean iM, short yob) {
        this.lname = last;
        this.fname = first;
        this.isMale = iM;
        this.yearOfBirth = yob;
    }
    // No Arg C-tor will give a random person
    public Person(){
        this.lname = randomStringName();
        this.fname = randomStringName();
        this.isMale = randomGender();
        this.yearOfBirth = randomYear();
    }

    public boolean isMale() {
        return isMale;
    }
    public String getLname(){
        return lname;
    }
    public String getFname(){
        return fname;
    }

    public short getYearOfBirth() {
        return yearOfBirth;
    }
    public void setLname(String lname){

    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setMale(boolean isMale){
        this.isMale = isMale;
    }
    public void setYearOfBirth(short yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return isMale == person.isMale && yearOfBirth == person.yearOfBirth && Objects.equals(fname, person.fname) && Objects.equals(lname, person.lname);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + fname.hashCode();
        result = result * 31 + lname.hashCode();
        result = result * 31 + yearOfBirth;
        int i = isMale ? 1231 : 1237;
        result = result + i;
        return result;
    }

    @Override
    public String toString(){
        return "First Name: " + this.fname +
                "\nLast Name: " + this.lname +
                "\nYear of Birth: " + this.yearOfBirth +
                "\nGender: " + getGender();
    }

    private String getGender() {
        if (isMale()) {
            return "Male";
        }
        else
            return "Female";
    }

    // Random Person creator

    static Random random = new Random();
    private String randomStringName(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int i;
        String name = "";
        for (i = 0; i < random.nextInt(3, 9); i++){
            int firstLetter = random.nextInt(26);
            int secondLetter = firstLetter + 2;
            if (firstLetter >= 24){
                secondLetter = firstLetter;
            }
            String twoLetters = alphabet.substring(firstLetter, secondLetter);
            name += twoLetters;
        }
        return name;
    }
    private boolean randomGender(){
        return random.nextBoolean();
    }
    private short randomYear(){
        int year = random.nextInt(1000, 2023);
        return (short) year;
    }

}

package edu.touro.cs.mcon364.comparators;

import java.util.Comparator;

public class ReverseAlphabetComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return str2.compareTo(str1);
    }
}

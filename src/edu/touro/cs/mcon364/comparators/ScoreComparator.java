package edu.touro.cs.mcon364.comparators;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}

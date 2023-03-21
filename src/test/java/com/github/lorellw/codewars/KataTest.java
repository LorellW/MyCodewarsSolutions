package com.github.lorellw.codewars;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class KataTest {
    @Test
    public void reverseWordsTest() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", Kata.reverseWords("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", Kata.reverseWords("apple"));
        assertEquals("a b c d", Kata.reverseWords("a b c d"));
        assertEquals("elbuod  decaps  sdrow", Kata.reverseWords("double  spaced  words"));
    }

    @Test
    public void makeTimeReadableTest() {
        assertEquals("makeReadable(0)", "00:00:00", Kata.makeTimeReadable(0));
        assertEquals("makeReadable(5)", "00:00:05", Kata.makeTimeReadable(5));
        assertEquals("makeReadable(60)", "00:01:00", Kata.makeTimeReadable(60));
        assertEquals("makeReadable(86399)", "23:59:59", Kata.makeTimeReadable(86399));
        assertEquals("makeReadable(359999)", "99:59:59", Kata.makeTimeReadable(359999));
    }

    @Test
    public void productFibTest() {
        long[] r = new long[] {55, 89, 1};
        assertArrayEquals(r, Kata.productFib(4895));
        long[] b = new long[] {89, 144, 0};
        assertArrayEquals(b, Kata.productFib(5895));
    }

    @Test
    public void dirReduction() {
        assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                Kata.dirReduction(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
                new String[]{},
                Kata.dirReduction(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
    }

    @Test
    public void orderWeightTest(){
        assertEquals("2000 103 123 4444 99", Kata.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", Kata.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

    @Test
    public void greedyTest(){
        assertEquals("Score for [5,1,3,4,1] must be 250:", 250, Kata.greedy(new int[]{5,1,3,4,1}));
        assertEquals("Score for [1,1,1,3,1] must be 1100:", 1100, Kata.greedy(new int[]{1,1,1,3,1}));
        assertEquals("Score for [2,4,4,5,4] must be 450:", 450, Kata.greedy(new int[]{2,4,4,5,4}));
    }
    @Test
    public void zerosTest(){
        assertThat(Kata.zeros(0), is(0));
        assertThat(Kata.zeros(6), is(1));
        assertThat(Kata.zeros(14), is(2));
    }
}
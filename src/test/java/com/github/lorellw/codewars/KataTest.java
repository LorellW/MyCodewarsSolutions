package com.github.lorellw.codewars;

import org.junit.Test;

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
}
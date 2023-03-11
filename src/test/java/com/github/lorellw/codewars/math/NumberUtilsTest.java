package com.github.lorellw.codewars.math;

import static com.github.lorellw.codewars.math.NumberUtils.sumIntervals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.lorellw.codewars.math.NextBiggerNumberSol;
import com.github.lorellw.codewars.math.NumberUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberUtilsTest {
    @Test
    void exampleTests() {
        assertTrue(NumberUtils.isNarcissistic(153), "153 is narcissistic");
        assertTrue(NumberUtils.isNarcissistic(1634), "1634 is narcissistic");
        assertFalse(NumberUtils.isNarcissistic(112), "112 is not narcissistic");
    }
    @Test
    void maxSequenceTest(){
        Assertions.assertEquals(0, NumberUtils.maxSequence(new int[]{}), "Empty arrays should have a max of 0");
        Assertions.assertEquals(6, NumberUtils.maxSequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), "Example array should have a max of 6");
        Assertions.assertEquals(0,NumberUtils.maxSequence(new int[]{-9,-12,-1,-3,0}));
    }

    @Test
    void bigAddTest() {
        Assertions.assertEquals("2", NumberUtils.bigAdd("1", "1"));
        Assertions.assertEquals("579", NumberUtils.bigAdd("123", "456"));
        Assertions.assertEquals("1110", NumberUtils.bigAdd("222", "888"));
        Assertions.assertEquals("1441", NumberUtils.bigAdd("1372", "69"));
        Assertions.assertEquals("468", NumberUtils.bigAdd("12", "456"));
        Assertions.assertEquals("201", NumberUtils.bigAdd("100", "101"));
        Assertions.assertEquals("91002328220491911630239667963", NumberUtils.bigAdd("63829983432984289347293874", "90938498237058927340892374089"));
        Assertions.assertEquals("15089607874",NumberUtils.bigAdd("3027529689","012062078185"));
    }

    @Test
    public void shouldHandleEmptyIntervals() {
        Assertions.assertEquals(0, sumIntervals(new int[][]{}));
        Assertions.assertEquals(0, sumIntervals(new int[][]{{4, 4}, {6, 6}, {8, 8}}));
    }

    @Test
    public void shouldAddDisjoinedIntervals() {
        Assertions.assertEquals(9, sumIntervals(new int[][]{{1, 2}, {6, 10}, {11, 15}}));
        Assertions.assertEquals(11, sumIntervals(new int[][]{{4, 8}, {9, 10}, {15, 21}}));
        Assertions.assertEquals(7, sumIntervals(new int[][]{{-1, 4}, {-5, -3}}));
        Assertions.assertEquals(78, sumIntervals(new int[][]{{-245, -218}, {-194, -179}, {-155, -119}}));
    }

    @Test
    public void shouldHandleLargeIntervals() {
        Assertions.assertEquals(2_000_000_000, sumIntervals(new int[][]{{-1_000_000_000, 1_000_000_000}}));
        Assertions.assertEquals(100_000_030, sumIntervals(new int[][]{{0, 20}, {-100_000_000, 10}, {30, 40}}));
    }

    @Test
    public void shouldAddAdjacentIntervals() {
        Assertions.assertEquals(54, sumIntervals(new int[][]{{1, 2}, {2, 6}, {6, 55}}));
        Assertions.assertEquals(23, sumIntervals(new int[][]{{-2, -1}, {-1, 0}, {0, 21}}));
    }

    @Test
    public void shouldAddOverlappingIntervals() {
        Assertions.assertEquals(5 ,sumIntervals(new int[][]{{1,5},{1,6}}));
        Assertions.assertEquals(6 ,sumIntervals(new int[][]{{1,5},{0,6}}));
        Assertions.assertEquals(19, sumIntervals(new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}));
        Assertions.assertEquals(7, sumIntervals(new int[][]{{1, 4}, {7, 10}, {3, 5}}));
        Assertions.assertEquals(6, sumIntervals(new int[][]{{5, 8}, {3, 6}, {1, 2}}));
    }

    @Test
    public void shouldHandleMixedIntervals() {
        Assertions.assertEquals(13, sumIntervals(new int[][]{{2, 5}, {-1, 2}, {-40, -35}, {6, 8}}));
        Assertions.assertEquals(1234, sumIntervals(new int[][]{{-7, 8}, {-2, 10}, {5, 15}, {2000, 3150}, {-5400, -5338}}));
        Assertions.assertEquals(158, sumIntervals(new int[][]{{-101, 24}, {-35, 27}, {27, 53}, {-105, 20}, {-36, 26},}));
    }

    @Test
    void nextBiggerNumber() {
        assertEquals(-1, NextBiggerNumberSol.nextBiggerNumber(4));
        assertEquals(-1,NextBiggerNumberSol.nextBiggerNumber(100000000));
        assertEquals(-1,NextBiggerNumberSol.nextBiggerNumber(543210000));
        assertEquals(-1,NextBiggerNumberSol.nextBiggerNumber(999999));
        assertEquals(21, NextBiggerNumberSol.nextBiggerNumber(12));
        assertEquals(531,NextBiggerNumberSol.nextBiggerNumber(513));
        assertEquals(2071,NextBiggerNumberSol.nextBiggerNumber(2017));
        assertEquals(441,NextBiggerNumberSol.nextBiggerNumber(414));
        assertEquals(414,NextBiggerNumberSol.nextBiggerNumber(144));
        assertEquals(19009, NextBiggerNumberSol.nextBiggerNumber(10990));
    }
}
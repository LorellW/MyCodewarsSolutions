package com.github.lorellw.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void validParenthesesTest() {
        assertTrue(Solution.validParentheses("()"));
        assertFalse(Solution.validParentheses("())"));
        assertTrue(Solution.validParentheses("32423(sgsdg)"));
        assertFalse(Solution.validParentheses("(dsgdsg))2432"));
        assertTrue(Solution.validParentheses("adasdasfa"));
    }

    @Test
    public void hexToRgbTest() {
        assertEquals("For input: (0, 0, 0)", "000000", Solution.hexToRgb(0, 0, 0));
        assertEquals("For input: (1, 2, 3)", "010203", Solution.hexToRgb(1, 2, 3));
        assertEquals("For input: (255, 255, 255)", "FFFFFF", Solution.hexToRgb(255, 255, 255));
        assertEquals("For input: (254, 253, 252)", "FEFDFC", Solution.hexToRgb(254, 253, 252));
        assertEquals("For input: (-20, 275, 125)", "00FF7D", Solution.hexToRgb(-20, 275, 125));
    }

    @Test
    public void rangeExtractionTest() {
        assertEquals("0-6", Solution.rangeExtraction(new int[]{0, 1, 2, 3, 4, 5, 6}));

        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", Solution.rangeExtraction(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));

        assertEquals("-3--1,2,10,15,16,18-20", Solution.rangeExtraction(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}));
    }
}
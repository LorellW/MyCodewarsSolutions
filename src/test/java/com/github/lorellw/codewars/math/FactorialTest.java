package com.github.lorellw.codewars.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest {

    @Test
    public void calculateFactorial() {
        assertEquals("1",Factorial.calculateFactorial(1));
        assertEquals("120",Factorial.calculateFactorial(5));
        assertEquals("362880",Factorial.calculateFactorial(9));
        assertEquals("1307674368000",Factorial.calculateFactorial(15));

    }

    @Test
    public void multiplication() {
        assertEquals("8",Factorial.multiplication("2","4"));
        assertEquals("0",Factorial.multiplication("0","15"));
        assertEquals("1058304",Factorial.multiplication("156","6784"));
    }
}
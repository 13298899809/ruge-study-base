package com.ruge.recursion.factorial;

import org.junit.Test;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TestFactorial
 * @date 2020.06.15 16:47
 */
public class TestFactorial {
    @Test
    public void test1() {
        int factorial = FactorialMethod.factorial(4);
        System.out.println(factorial);
    }
}

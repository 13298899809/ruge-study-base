package com.ruge.recursion.factorial;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName FactorialMethod1
 * @date 2020.06.15 09:36
 */
public class FactorialMethod {

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n; // 1 * 2 * 3
        }
    }

    public static int factorialByFor(int n) {
        int result = 1;
        if (n < 0) {
            return -1;//返回-1，说明传入数据不合法
        }
        if (n == 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

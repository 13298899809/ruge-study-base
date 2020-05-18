package com.ruge.guava.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.*;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName JoinerTest
 * @date 2020.05.18 10:13
 */
public class JoinerTest extends TestCase {

    // <Integer> needed to prevent warning :(
    private static final Iterable<Integer> ITERABLE_ = Arrays.<Integer>asList();
    private static final Iterable<Integer> ITERABLE_1 = Arrays.asList(1);
    private static final Iterable<Integer> ITERABLE_12 = Arrays.asList(1, 2);
    private static final Iterable<Integer> ITERABLE_123 = Arrays.asList(1, 2, 3);
    private static final Iterable<Integer> ITERABLE_NULL = Arrays.asList((Integer) null);
    private static final Iterable<Integer> ITERABLE_NULL_NULL = Arrays.asList((Integer) null, null);
    private static final Iterable<Integer> ITERABLE_NULL_1 = Arrays.asList(null, 1);
    private static final Iterable<Integer> ITERABLE_1_NULL = Arrays.asList(1, null);
    private static final Iterable<Integer> ITERABLE_1_NULL_2 = Arrays.asList(1, null, 2);
    private static final Iterable<Integer> ITERABLE_FOUR_NULLS =
            Arrays.asList((Integer) null, null, null, null);

    public void test_join() {
        System.out.println(Joiner.on("-").join(ITERABLE_1));
    }

    public void test_join2() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("333");
        System.out.println(Joiner.on("-").appendTo(stringBuilder,ITERABLE_123));
    }
}

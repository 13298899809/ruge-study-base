package com.ruge.guava.base;

import com.google.common.base.Splitter;
import junit.framework.TestCase;

import java.util.List;

import static com.google.common.collect.ImmutableList.toImmutableList;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName SplitterTest
 * @date 2020.05.18 13:39
 */
public class SplitterTest extends TestCase {

    public void test_split() {
        String simple = "a,b,c";
        Iterable<String> letters = Splitter.on(',').split(simple);
        letters.forEach(System.out::println);
    }

    public void test_splitToList() {
        String simple = "a,b,c";
        List<String> letters = Splitter.on(',').splitToList(simple);
        letters.forEach(System.out::println);
    }

    public void test_OmitEmptyStrings() {
        String doubled = "a..b.c";
        Iterable<String> letters = Splitter.on('.').omitEmptyStrings().split(doubled);
    }

    public void test_splitToStream() {
        String simple = "a,b,c";
        List<String> letters = Splitter.on(',').splitToStream(simple).collect(toImmutableList());
        letters.forEach(System.out::println);
    }
}

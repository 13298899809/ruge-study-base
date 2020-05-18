package com.ruge.guava.base;

import com.google.common.base.Strings;
import junit.framework.TestCase;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName StringsTest
 * @date 2020.05.18 14:14
 */
public class StringsTest extends TestCase {

    public void test_IsNullOrEmpty() {
        assertTrue(Strings.isNullOrEmpty(null));
        assertTrue(Strings.isNullOrEmpty(""));
        assertFalse(Strings.isNullOrEmpty("a"));
    }

    public void test_NullToEmpty() {
        assertEquals("", Strings.nullToEmpty(null));
        assertEquals("", Strings.nullToEmpty(""));
        assertEquals("a", Strings.nullToEmpty("a"));
    }

    public void test_EmptyToNull() {
        assertNull(Strings.emptyToNull(null));
        assertNull(Strings.emptyToNull(""));
        assertEquals("a", Strings.emptyToNull("a"));
    }

    public void test_Repeat() {
        String input = "20";
        assertEquals("", Strings.repeat(input, 0));
        assertEquals("20", Strings.repeat(input, 1));
        assertEquals("2020", Strings.repeat(input, 2));
        assertEquals("202020", Strings.repeat(input, 3));
        assertEquals("", Strings.repeat("", 4));
    }

    public void testPadStart_somePadding() {
        assertEquals("-", Strings.padStart("", 1, '-'));
        assertEquals("--", Strings.padStart("", 2, '-'));
        assertEquals("-x", Strings.padStart("x", 2, '-'));
        assertEquals("--x", Strings.padStart("x", 3, '-'));
        assertEquals("-xx", Strings.padStart("xx", 3, '-'));
    }


    public void testCommonPrefix() {
        assertEquals("", Strings.commonPrefix("", ""));
        assertEquals("", Strings.commonPrefix("abc", ""));
        assertEquals("", Strings.commonPrefix("", "abc"));
        assertEquals("", Strings.commonPrefix("abcde", "xyz"));
        assertEquals("", Strings.commonPrefix("xyz", "abcde"));
        assertEquals("", Strings.commonPrefix("xyz", "abcxyz"));
        assertEquals("a", Strings.commonPrefix("abc", "aaaaa"));
        assertEquals("aa", Strings.commonPrefix("aa", "aaaaa"));
        assertEquals("abc", Strings.commonPrefix(new StringBuffer("abcdef"), "abcxyz"));

        // Identical valid surrogate pairs.
        assertEquals(
                "abc\uD8AB\uDCAB", Strings.commonPrefix("abc\uD8AB\uDCABdef", "abc\uD8AB\uDCABxyz"));
        // Differing valid surrogate pairs.
        assertEquals("abc", Strings.commonPrefix("abc\uD8AB\uDCABdef", "abc\uD8AB\uDCACxyz"));
        // One invalid pair.
        assertEquals("abc", Strings.commonPrefix("abc\uD8AB\uDCABdef", "abc\uD8AB\uD8ABxyz"));
        // Two identical invalid pairs.
        assertEquals(
                "abc\uD8AB\uD8AC", Strings.commonPrefix("abc\uD8AB\uD8ACdef", "abc\uD8AB\uD8ACxyz"));
        // Two differing invalid pairs.
        assertEquals("abc\uD8AB", Strings.commonPrefix("abc\uD8AB\uD8ABdef", "abc\uD8AB\uD8ACxyz"));
        // One orphan high surrogate.
        assertEquals("", Strings.commonPrefix("\uD8AB\uDCAB", "\uD8AB"));
        // Two orphan high surrogates.
        assertEquals("\uD8AB", Strings.commonPrefix("\uD8AB", "\uD8AB"));
    }

    public void testCommonSuffix() {
        assertEquals("", Strings.commonSuffix("", ""));
        assertEquals("", Strings.commonSuffix("abc", ""));
        assertEquals("", Strings.commonSuffix("", "abc"));
        assertEquals("", Strings.commonSuffix("abcde", "xyz"));
        assertEquals("", Strings.commonSuffix("xyz", "abcde"));
        assertEquals("", Strings.commonSuffix("xyz", "xyzabc"));
        assertEquals("c", Strings.commonSuffix("abc", "ccccc"));
        assertEquals("aa", Strings.commonSuffix("aa", "aaaaa"));
        assertEquals("abc", Strings.commonSuffix(new StringBuffer("xyzabc"), "xxxabc"));

        // Identical valid surrogate pairs.
        assertEquals(
                "\uD8AB\uDCABdef", Strings.commonSuffix("abc\uD8AB\uDCABdef", "xyz\uD8AB\uDCABdef"));
        // Differing valid surrogate pairs.
        assertEquals("def", Strings.commonSuffix("abc\uD8AB\uDCABdef", "abc\uD8AC\uDCABdef"));
        // One invalid pair.
        assertEquals("def", Strings.commonSuffix("abc\uD8AB\uDCABdef", "xyz\uDCAB\uDCABdef"));
        // Two identical invalid pairs.
        assertEquals(
                "\uD8AB\uD8ABdef", Strings.commonSuffix("abc\uD8AB\uD8ABdef", "xyz\uD8AB\uD8ABdef"));
        // Two differing invalid pairs.
        assertEquals("\uDCABdef", Strings.commonSuffix("abc\uDCAB\uDCABdef", "abc\uDCAC\uDCABdef"));
        // One orphan low surrogate.
        assertEquals("", Strings.commonSuffix("x\uD8AB\uDCAB", "\uDCAB"));
        // Two orphan low surrogates.
        assertEquals("\uDCAB", Strings.commonSuffix("\uDCAB", "\uDCAB"));
    }


    public void testLenientFormat() {
        assertEquals("%s", Strings.lenientFormat("%s"));
        assertEquals("5", Strings.lenientFormat("%s", 5));
        assertEquals("foo [5]", Strings.lenientFormat("foo", 5));
        assertEquals("foo [5, 6, 7]", Strings.lenientFormat("foo", 5, 6, 7));
        assertEquals("%s 1 2", Strings.lenientFormat("%s %s %s", "%s", 1, 2));
        assertEquals(" [5, 6]", Strings.lenientFormat("", 5, 6));
        assertEquals("123", Strings.lenientFormat("%s%s%s", 1, 2, 3));
        assertEquals("1%s%s", Strings.lenientFormat("%s%s%s", 1));
        assertEquals("5 + 6 = 11", Strings.lenientFormat("%s + 6 = 11", 5));
        assertEquals("5 + 6 = 11", Strings.lenientFormat("5 + %s = 11", 6));
        assertEquals("5 + 6 = 11", Strings.lenientFormat("5 + 6 = %s", 11));
        assertEquals("5 + 6 = 11", Strings.lenientFormat("%s + %s = %s", 5, 6, 11));
        assertEquals("null [null, null]", Strings.lenientFormat("%s", null, null, null));
        assertEquals("null [5, 6]", Strings.lenientFormat(null, 5, 6));
        assertEquals("null", Strings.lenientFormat("%s", (Object) null));
        assertEquals("(Object[])null", Strings.lenientFormat("%s", (Object[]) null));
    }
}

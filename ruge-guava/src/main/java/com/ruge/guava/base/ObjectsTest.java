package com.ruge.guava.base;

import com.google.common.base.Objects;
import junit.framework.TestCase;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName ObjectsTest
 * @date 2020.05.18 14:10
 */
public class ObjectsTest extends TestCase {
    public void testEqual() throws Exception {
        assertTrue(Objects.equal(1, 1));
        assertTrue(Objects.equal(null, null));

        // test distinct string objects
        String s1 = "foobar";
        String s2 = new String(s1);
        assertTrue(Objects.equal(s1, s2));

        assertFalse(Objects.equal(s1, null));
        assertFalse(Objects.equal(null, s1));
        assertFalse(Objects.equal("foo", "bar"));
        assertFalse(Objects.equal("1", 1));
    }
}

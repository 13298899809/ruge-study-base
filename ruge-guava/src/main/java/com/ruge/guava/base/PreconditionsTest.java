package com.ruge.guava.base;

import com.google.common.base.Preconditions;
import junit.framework.TestCase;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName PreconditionsTest
 * @date 2020.05.18 14:01
 */
public class PreconditionsTest extends TestCase {
    public void testCheckArgument_simple_success() {
        Preconditions.checkArgument(true);
        Preconditions.checkNotNull(null, "this_is_null");
    }

}

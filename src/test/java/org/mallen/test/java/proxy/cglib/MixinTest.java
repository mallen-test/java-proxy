package org.mallen.test.java.proxy.cglib;

import net.sf.cglib.proxy.Mixin;
import org.junit.Assert;
import org.junit.Test;
import org.mallen.test.java.proxy.cglib.mixin.*;

/**
 * @author mallen
 * @date 2/20/19
 */
public class MixinTest {
    @Test
    public void test() {
        Mixin mixin = Mixin.create(
                new Class[]{Interface1.class, Interface2.class, MixinInterface.class},
                new Object[]{new First(), new Second()}
        );

        MixinInterface mixinInterface = (MixinInterface) mixin;
        Assert.assertEquals("first behaviour", mixinInterface.first());
        Assert.assertEquals("second behaviour", mixinInterface.second());
    }
}

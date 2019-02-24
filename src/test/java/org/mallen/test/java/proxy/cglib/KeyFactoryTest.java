package org.mallen.test.java.proxy.cglib;

import net.sf.cglib.core.KeyFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mallen
 * @date 2/22/19
 */
public class KeyFactoryTest {
    @Test
    public void keyFactoryTest() {
        SampleKeyFactory keyFactory = (SampleKeyFactory) KeyFactory.create(SampleKeyFactory.class);
        Object key = keyFactory.newInstance("mallen", 18);
        Map<Object, String> map = new HashMap<>();
        map.put(key, "mallen");
        Assert.assertEquals("mallen", map.get(keyFactory.newInstance("mallen", 18)));
    }

    private static interface SampleKeyFactory{
        Object newInstance(String first, int second);
    }
}

package org.mallen.test.java.proxy.cglib;

import net.sf.cglib.beans.BeanGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author mallen
 * @date 2/20/19
 */
public class BeanGeneratorTest {
    @Test
    public void generateBeanTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator generator = new BeanGenerator();
        generator.addProperty("name", String.class);

        Object bean = generator.create();
        Method setter = bean.getClass().getMethod("setName", String.class);
        setter.invoke(bean, "mallen");
        Method getter = bean.getClass().getMethod("getName");
        String name = (String) getter.invoke(bean, null);

        Assert.assertEquals("mallen", name);
    }
}

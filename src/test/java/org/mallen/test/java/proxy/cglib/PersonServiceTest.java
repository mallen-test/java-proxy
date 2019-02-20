package org.mallen.test.java.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author mallen
 * @date 2/20/19
 */
public class PersonServiceTest {

    @Test
    public void FixedValueTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue) () -> "Hello Tom");

        PersonService proxy = (PersonService) enhancer.create();
        String res = proxy.sayHello(null);
        Assert.assertEquals("Hello Tom", res);
    }

    @Test
    public void MethodInterceptorTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "Hello Tom";
            }

            return proxy.invokeSuper(obj, args);
        });
        PersonService proxy = (PersonService) enhancer.create();

        String res = proxy.sayHello(null);
        Assert.assertEquals("Hello Tom", res);

        int length = proxy.lengthOfName("mallen");
        Assert.assertEquals(6, length);
    }
}

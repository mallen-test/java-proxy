package org.mallen.test.java.proxy.cglib;

import net.sf.cglib.proxy.*;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author mallen
 * @date 2/21/19
 */
public class CallbackFilterTest {
    @Test
    public void testCallbackFilter() {
        Enhancer enhancer = new Enhancer();
        CallbackHelper callbackHelper = new CallbackHelper(PersonService.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return (FixedValue)() -> "Hello cglib!";
                } else {
                    return NoOp.INSTANCE;
                }
            }
        };
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        PersonService personServiceProxy = (PersonService) enhancer.create();

        Assert.assertEquals("Hello cglib!", personServiceProxy.sayHello(null));
        Assert.assertNotEquals("Hello cglib!", personServiceProxy.lengthOfName("mallen"));
    }
}

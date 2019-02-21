package org.mallen.test.java.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author mallen
 * @date 2/21/19
 */
public class CreateClassTest {
    @Test
    public void constructorTest() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallbackType(FixedValue.class);
        Class proxyClass = enhancer.createClass();
        // 注册回调
        Enhancer.registerCallbacks(proxyClass, new Callback[]{(FixedValue)()-> "hello mallen"});
        PersonService personService = null;
        Constructor<PersonService>[] constructors = proxyClass.getDeclaredConstructors();
            for (Constructor<PersonService> constructor : constructors) {
            if (constructor.getParameterCount() == 1) {
                personService = constructor.newInstance("mallen");
                break;
            }
        }
        if (personService != null) {
            System.out.println(personService.sayHello(null));
        }
    }
}

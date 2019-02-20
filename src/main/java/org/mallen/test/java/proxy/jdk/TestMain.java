package org.mallen.test.java.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author mallen
 * @date 2/15/19
 */
public class TestMain {
    public static void main(String[] args) {
        AroundLogInvocationHandler invocationHandler = new AroundLogInvocationHandler(new TestServiceImpl());

        TestService proxy = (TestService) Proxy.newProxyInstance(
                TestService.class.getClassLoader(),
                new Class[]{TestService.class},
                invocationHandler
        );

        String test = proxy.test();
        System.out.println(test);
    }
}

package org.mallen.test.java.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author mallen
 * @date 2/15/19
 */
public class AroundLogInvocationHandler implements InvocationHandler {
    /**
     * 要代理的原始对象
     */
    private Object obj;

    public AroundLogInvocationHandler(Object obj) {
        this.obj = obj;
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object ret = method.invoke(obj, args);
        doAfter();
        return ret;
    }

    private void doAfter() {
        System.out.println("Test proxy handler after");
    }

    private void doBefore() {
        System.out.println("Test proxy handler before");
    }


}

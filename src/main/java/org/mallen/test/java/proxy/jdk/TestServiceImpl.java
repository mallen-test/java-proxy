package org.mallen.test.java.proxy.jdk;

/**
 * java的动态代理，只能在类实现了接口时才能使用
 *
 * @author mallen
 * @date 2/15/19
 */
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        System.out.println("进入test方法");
        return "this java dynamic proxy test";
    }
}

package org.mallen.test.java.proxy.cglib.mixin;

/**
 * @author mallen
 * @date 2/20/19
 */
public class Second implements Interface2 {
    @Override
    public String second() {
        return "second behaviour";
    }
}

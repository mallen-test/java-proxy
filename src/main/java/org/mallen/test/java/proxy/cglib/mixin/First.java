package org.mallen.test.java.proxy.cglib.mixin;

/**
 * @author mallen
 * @date 2/20/19
 */
public class First implements Interface1 {
    private String name;

    @Override
    public String first() {
        return "first behaviour";
    }
}

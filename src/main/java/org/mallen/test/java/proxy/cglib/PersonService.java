package org.mallen.test.java.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

/**
 * @author mallen
 * @date 2/19/19
 */
public class PersonService {
    public String sayHello(String name) {
        System.out.println("sayHello called");
        return "Hello " + name;
    }

    public Integer lengthOfName(String name) {
        System.out.println("lengthOfName called");
        return name.length();
    }


}

package org.mallen.test.java.proxy.cglib;

/**
 * @author mallen
 * @date 2/19/19
 */
public class PersonService {
    private String name;

    public PersonService() {
    }

    public PersonService(String name) {
        System.out.println("有参构造方法被调用，name=" + name);
        this.name = name;
    }

    public String sayHello(String name) {
        System.out.println("sayHello called");
        return "Hello " + name;
    }

    public Integer lengthOfName(String name) {
        System.out.println("lengthOfName called");
        return name.length();
    }


}

package org.mallen.test.java.proxy.cglib.lazyloader;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.LazyLoader;

/**
 * @author mallen
 * @date 2/21/19
 */
public class User {
    private String name;
    private Address address;

    public User() {
        this.name = "user.name";
        this.address = createAddress();
    }

    private Address createAddress() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Address.class);
        enhancer.setCallback((LazyLoader) () -> {
            System.out.println("*********开始创建Address实例*********");
            Address address = new Address();
            // 该回调仅会在第一次使用address的属性时调用一次，后续就直接使用第一次创建的实例了
            address.setDetail("address.detail");
            return address;
        });
        return (Address) enhancer.create();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

package org.mallen.test.java.proxy.cglib;

import org.junit.Test;
import org.mallen.test.java.proxy.cglib.lazyloader.Address;
import org.mallen.test.java.proxy.cglib.lazyloader.User;

/**
 * @author mallen
 * @date 2/21/19
 */
public class LazyLoaderTest {
    @Test
    public void lazyLoaderTest() {
        User user = new User();
        System.out.println(user.getName());
        System.out.println("获取user.address");
        Address address = user.getAddress();
        System.out.println("获取user.address.detail");
        System.out.println(address.getDetail());

        System.out.println("再次获取user.address和user.address.detail");
        address = user.getAddress();
        System.out.println(address.getDetail());
    }
}

package org.mallen.test.java.proxy.cglib;

import net.sf.cglib.beans.BeanMap;
import org.junit.Assert;
import org.junit.Test;
import org.mallen.test.java.proxy.cglib.bulkbean.MultiFieldBean;

/**
 * @author mallen
 * @date 2/22/19
 */
public class BeanMapTest {
    @Test
    public void beanMapTest() {
        PersonService personService = new PersonService();
        personService.setName("mallen");
        BeanMap beanMap = BeanMap.create(personService);
        Assert.assertEquals("mallen", beanMap.get("name"));
        // 可以使用newInstance方法继续转换bean，不需要再创建BeanMap实例
        beanMap = beanMap.newInstance(new PersonService("mallen1"));
        Assert.assertEquals("mallen1", beanMap.get("name"));
        // 使用newInstance方法可以使用非第一次指定的Class，但是在获取entrySet的时候会强制转换为第一次指定的Class，导致无法使用数据
//        MultiFieldBean multiFieldBean = new MultiFieldBean("mallen huang", "chengdu", 18);
//        beanMap = beanMap.newInstance(multiFieldBean);
//        System.out.println(beanMap.keySet());
//        System.out.println(beanMap.entrySet());
    }
}

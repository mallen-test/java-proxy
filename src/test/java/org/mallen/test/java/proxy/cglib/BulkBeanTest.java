package org.mallen.test.java.proxy.cglib;

import net.sf.cglib.beans.BulkBean;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mallen.test.java.proxy.cglib.bulkbean.MultiFieldBean;

/**
 * @author mallen
 * @date 2/21/19
 */
public class BulkBeanTest {
    @Test
    public void bulkBeanTest() {
        BulkBean bulkBean = BulkBean.create(MultiFieldBean.class,
                new String[]{"getName", "getAge", "getAddress"},
                new String[]{"setName", "setAge", "setAddress"},
                new Class[]{String.class, Integer.class, String.class}
        );
        MultiFieldBean bean = new MultiFieldBean("mallen", "chengdu", 18);
        Object[] values = bulkBean.getPropertyValues(bean);
        assertEquals("mallen", values[0]);
        assertEquals(18, values[1]);
        assertEquals("chengdu", values[2]);
        // 设置属性
        bulkBean.setPropertyValues(bean, new Object[]{"mallen1", 19, "chengdu1"});
        values = bulkBean.getPropertyValues(bean);
        assertEquals("mallen1", values[0]);
        assertEquals(19, values[1]);
        assertEquals("chengdu1", values[2]);
    }
}

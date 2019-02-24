package org.mallen.test.java.proxy.cglib;

import net.sf.cglib.util.ParallelSorter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author mallen
 * @date 2/24/19
 */
public class ParallelSorterTest {
    @Test
    public void parallelSorterTest() {
        Integer[][] value = {
                {1, 3, 5, 7, 9, 2, 4, 6},
                {1, 3, 5, 7, 9, 2, 4, 6}
                ,
                {1, 3, 5, 7, 9, 2, 4, 6},
        };

        ParallelSorter.create(value).mergeSort(0);
        for (Integer[] val : value) {
            int former = -1;
            for (int v : val) {
                Assert.assertTrue(former < v);
                former = v;
            }
        }

        System.out.println(value);
    }
}

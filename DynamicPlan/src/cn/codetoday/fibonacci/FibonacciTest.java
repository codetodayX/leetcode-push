package cn.codetoday.fibonacci;

import org.junit.Test;

/**
 * @author: codetoday
 * @date: 2021-10-21 22:46
 */
public class FibonacciTest {
    @Test
    public void test1() {
        System.out.println(FibonacciByMemo.fibonacci(20));
    }

    @Test
    public void test2() {
        System.out.println(FibonacciByDPTable.fibonacci2(20));
    }
}

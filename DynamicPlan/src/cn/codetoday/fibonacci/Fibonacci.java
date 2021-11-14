package cn.codetoday.fibonacci;

/**
 * @author: codetoday
 * @date: 2021-10-17 12:42
 */
public class Fibonacci {
    //时间复杂度O(2^n),存在重复计算，效率底下
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


}

package cn.codetoday.fibonacci;

/**
 * @author: codetoday
 * @date: 2021-10-21 22:37
 * 斐波那契数列 备忘录递归方式
 */
public class FibonacciByMemo {
    public static int fibonacci(int n) {
        //1.创建备忘录
        int[] memo = new int[n];
        if (n > 1) {    //防止数组下标越界
            memo[1] = 1;
        }
        //2.递归调用
        return fibonacciByMemo(n, memo);
    }

    private static int fibonacciByMemo(int n, int[] memo) {
        //1.n=1或者n=2，值固定为0,1
        if (n == 1 || n == 2) {
            return memo[n - 1];
        }
        //2.首先判断备忘录是否存在该值,存在则返回，无需再递归，否则递归查询，并将结果保存在备忘录，然后返回结果
        if (memo[n - 1] != 0) {
            return memo[n - 1];
        }
        memo[n - 1] = fibonacciByMemo(n - 1, memo) + fibonacciByMemo(n - 2, memo);
        return memo[n - 1];
    }
}

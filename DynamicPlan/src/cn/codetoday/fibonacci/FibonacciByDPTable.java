package cn.codetoday.fibonacci;

/**
 * @author: codetoday
 * @date: 2021-10-23 19:36
 * 求解斐波那契数列-DP Table方式
 */
public class FibonacciByDPTable {
    //时间复杂度O(n),空间复杂度O(n)
    public static int fibonacci1(int n) {
        //1.创建DPTable
        int[] DPTable = new int[n + 1];
        DPTable[1] = 1;
        DPTable[2] = 1;
        //2.自底向上求解
        for (int i = 3; i <= n; i++) {
            DPTable[i] = DPTable[i - 1] + DPTable[i - 2];
        }
        return DPTable[n];
    }

    //优化:空间复杂度将为O(1)
    public static int fibonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        //1.保存当前状态的前两个状态
        int preState1 = 1;
        int preState2 = 1;
        int curState = preState1 + preState2;
        for (int i = 3; i <= n; i++) {
            curState = preState1 + preState2;
            //重新设置状态
            preState1 = preState2;
            preState2 = curState;
        }
        return curState;
    }
}

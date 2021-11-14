package cn.codetoday.loosechange;

/**
 * @author: codetoday
 * @date: 2021-10-23 20:50
 */
public class LooseChange {
    public static void main(String[] args) {
        LooseChange looseChange = new LooseChange();
        int[] k = new int[10];
        for (int i = 0; i < k.length; i++) {
            k[i] = i + 1;
        }
//        System.out.println(looseChange.dp(k, 100));
        System.out.println(looseChange.dpByMemo(k, 100));
        System.out.println(looseChange.dpByIter(k, 100));
    }

    /**
     * 凑零钱问题递归解法
     *
     * @param k      k种面值的硬币
     * @param amount 目标金额
     * @return
     */
    public int dp(int[] k, int amount) {
        //1.明确base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        //2.计算子问题的结果
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k.length; i++) {
            int subRes = dp(k, amount - k[i]);
            //子问题结果为-1则跳过
            if (subRes < 0) {
                continue;
            }
            //3.在子问题结果中选择最优解
            res = Math.min(res, subRes + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dp(int[] k, int amount, int[] memo) {
        //1.明确base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        //查询备忘录,防止重复计算
        if (memo[amount] != 0) return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k.length; i++) {
            int subRes = dp(k, amount - k[i], memo);
            if (subRes < 0) continue;
            //3.从当前子问题的最优解和上一个子问题的最优解中选出最优解
            res = Math.min(res, subRes + 1);
        }

        //更新备忘录
        return memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 凑零钱问题-使用备忘录解决重叠子问题
     *
     * @param k
     * @param amount
     * @return
     */
    public int dpByMemo(int[] k, int amount) {
        //创建备忘录
        int[] memo = new int[amount + 1];

        return dp(k, amount, memo);
    }


    /**
     * 自底向上 dp数组迭代解法
     *
     * @return
     */
    public int dpByIter(int[] k, int amount) {
        int[] dp = new int[amount + 1];
        //明确状态
        for (int i = 1; i <= amount; i++) {
            int res = Integer.MAX_VALUE;
            //明确选择
            for (int j = 0; j < k.length; j++) {
                if (i - k[j] < 0) continue;
                int subRes = dp[i - k[j]] + 1;
                res = Math.min(subRes, res);
            }
            dp[i] = res == Integer.MAX_VALUE ? -1 : res;
        }
        return dp[amount];
    }
}

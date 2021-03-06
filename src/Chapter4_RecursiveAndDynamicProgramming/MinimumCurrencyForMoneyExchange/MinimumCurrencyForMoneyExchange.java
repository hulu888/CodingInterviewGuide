package Chapter4_RecursiveAndDynamicProgramming.MinimumCurrencyForMoneyExchange;

/**
 换钱的最少货币数

 【题目】
    给定数组 arr， arr 中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数 aim 代表
    要找的钱数，求组成 aim 的最少货币数

 【举例】
    arr = [5, 2, 3] , aim = 20
    4 张 5 元可以组成20元，其他的方案都要使用更多张数的货币，所以返回 4

    arr = [5, 2, 3] , aim = 0
    不用任何货币就可以组成 0 元， 返回 0

    arr = [3, 5] , aim = 2
    无法组成 2 元， 钱不能找开的情况下默认返回 -1

 【思路】
    经典的动态规划。如果 arr 的长度 N ，生成行数为 N 、列数为 aim + 1 的动态规划表的 dp 。 dp[i][j] 的含义是，在任意使用 arr[0 .. i]
    货币的情况下，组成 j 所需的最小张数。根据这个定义，dp[i][j]的值按如下方式计算：
        1. dp[0 .. N-1][0]的值（即 dp 矩阵中第一列的值）表示找的钱数为 0 时需要的最少张数，钱数为 0 时，完全不需要任何货币，所以全
            设为0
        2. dp[0][0 .. aim]的值（即第一行的值）表示只能使用 arr[0]货币的情况下，找某个钱数的最小张数，比如，arr[0]=2，那么能召开的钱数为
            2，4,6,8 ... 所以令dp[0][2]=1，dp[0][4]=2，dp[0][6]=3，... 第一行其他位置所代表的钱数一律找不开，所以一律设为 32 位
            整数的最大值，我们把这个记为 max
        3. 剩下的位置一次从左到右，在从上到下计算。假设计算到位置 (i, j)，dp[i][j]的值可能来自下面的情况：
            (1) 完全不使用当前货币 arr[i] 情况下的最少张数，即 dp[i-1][j]的值
            (2) 只使用 1 张当前货币 arr[i] 情况下的最少张数，即 dp[i-1][j-arr[i]] + 1
            (3) 只使用 2 张当前货币 arr[i] 情况下的最少张数，即 dp[i-1][j-2*arr[i]] + 2
            (4) 只使用 3 张当前货币 arr[i] 情况下的最少张数，即 dp[i-1][j-3*arr[i]] + 3
        dp[i][j] = min{dp[i-1][j-k*arr[i]+k (0<=k)}
        ==> dp[i][j] = min{dp[i-1][j], min{dp[i-1][j-x*arr[i]] + x (1<=x)}}
        ==> dp[i][j] = min{dp[i-1][j], min{dp[i-1][j-arr[i]-y*arr[i]]+y+1 (0<=y)}}

        又因为min{dp[i-1][j-arr[i]-y*arr[i]]+y,(0<=y)} ==>dp[i][j-arr[i]],所以
        dp[i][j] = min{dp[i-1][j],dp[i][j-arr[i]]+1}

 【补充题目】
    给定数组 arr ， arr 中所有的值都为正数。每个值仅代表一张钱的面值，在给定一个整数 aim 代表要找的钱数，求组成 aim 的最少货币数

 【举例】
    arr = [5, 2, 3] , aim = 20
    5 元、2 元和 3 元的钱各有 1 张， 所以无法组成 20 元， 默认返回 -1

    arr = [5, 2, 5, 3] , aim = 10
    5 元的货币有 2 张， 可以组成 10 元， 且该方案所需张数最少， 返回 2

    arr = [5, 2, 5, 3] , aim = 15
    所有的钱加起来才能组成 15 元， 返回 4

    arr = [5, 2, 5, 3] , aim = 0
    不同任何货币就可以组成 0 元， 返回 0

 */


public class MinimumCurrencyForMoneyExchange {

    // 题目1
    public static int minimumCurrencyForMoneyExchange(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int dp[][] = new int[n][aim + 1];
        for (int j = 1; j <= aim; j++){
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++){
            for (int j = 1; j <= aim; j++){
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max){
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i-1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }


}















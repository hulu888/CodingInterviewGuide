package Chapter4_RecursiveAndDynamicProgramming.SumOfMinimumDistancesOfMatrix;

import java.util.Arrays;

/**
 【题目】
    给定一个矩阵 m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中
    最小的路径和。
 【举例】
    如果给定的 m 如下：
    1   3   5   9
    8   1   3   4
    5   0   6   1
    8   8   4   0
    路径1,3,1,0,6,1,0 是所有路径和最小的，所以返回12
 【思路】
    经典动态规划方法。假设矩阵m的大小为MxN,行数为M,列数为N,先生成大小和m一样的矩阵dp, dp[i][j])的值表示从左上角(即(0,0))位置
    走到(i,j)位置的最小路径和。对m的第一行的所有位置来说,即(0,j)(0<=j<M),从(0,0)位置走到(0,j)位置只能向右走,所以(0,0)位置到(0,j)
    位置的路径和就是m[0][0..j]这些值的累加结果。同理,对m的第一列的所有位置来说,即(i,0)0<=i<M),从(0,0)位置走到(i,0)位置只能向下走,
    所以(0,0)位置到(i,0)位置的路径和就是m[0..i][0]这些值的累加结果。
    除了第一行和第一列之外，其余的位置可以得到状态方程：dp[i][j] = min{dp[i-1][j], dp[i][j-1]} + m[i][j]

 */

public class SumOfMinimumDistancesOfMatrix {
    public static int sumOfMinimumDistancesOfMatrix1(int[][] m){
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0){
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];

        dp[0][0] = m[0][0];

        // 将矩阵m的第一列赋值给dp
        for (int i = 1; i < row; i++){
            dp[i][0] = dp[i-1][0] + m[i][0];
        }
        // 将矩阵m的第一行赋值给dp
        for (int i = 1; i < col; i++){
            dp[0][i] = dp[0][i-1] + m[0][i];
        }
        // 计算其余位置的最小值
        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,9}, {8,1,3,4}, {5,0,6,1}, {8,8,4,0}};
        System.out.println(sumOfMinimumDistancesOfMatrix1(arr));
    }
}

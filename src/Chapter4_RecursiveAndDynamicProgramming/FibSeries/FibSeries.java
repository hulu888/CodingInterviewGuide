package Chapter4_RecursiveAndDynamicProgramming.FibSeries;

import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 【题目】
    给定整数N，返回斐波拉契数列的第N项
    【举例】
        n = 1   1
        n = 2   1
        n = 3   2
        n = 4   3
        n = 5   5


 【补充题目 1】
    给定整数N，代表台阶数，一次可以跨2个或者1个台阶，返回有多少种走法
    【举例】
        N = 3，可以三次都跨一个台阶；也可以先跨2个台阶，再跨1个台阶；还可以先跨1个台阶，在跨2个台阶。所以有3种走法
    【思路】
        根据动态规划，可以列出状态方程：f(n) = f(n - 1) + f(n - 2)

 【补充题目2】
    假设农场中成熟的母牛每年会生 1头小牛，并且永远不死。第一年农场有 1只成熟的母牛，从第二年开始，母牛开始生小母牛。每只小母牛3年后
    成熟又可以生小母牛。给定整数N，求出N年后牛的数量

    【举例】
        N = 6，第1年1头母牛记为a,第2年a生了新的小母牛，记为b，总牛数为2；第3年a生了新的小母牛，记为c，总牛数为3，第4年a生了新的小
        母牛，记为d,总牛数为4，,第5年b成熟了，a和b分别生了小母牛，总牛数为6；第6年c也成熟了，a、b和c分别生了新的小牛，总牛数为9.

 【要求】
    对以上所有的问题，请实现时间复杂度为 O(logN)的解法
 */
public class FibSeries {

    // 斐波拉契数列递归实现，时间复杂度O(2^N)
    public static int fib1(int n){
        if (n < 1){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }
    // 斐波拉契数列非递归实现，时间复杂度O(N)
    public static int fib2(int n){
        if (n < 1){
            return 0;
        }
        int pre = 1, pPre = 1, cur=0;
        if (n == 1 || n == 2){
            return 1;
        }
        for(int i = 3; i <= n; i++){
            cur = pre + pPre;
            pPre = pre;
            pre = cur;
        }
        return cur;
    }

    // 补充题1：递归方法
    public static int stairs1(int n){
        if (n < 1){
            return 0;
        }
        if (n == 1 || n == 2){
            return n;
        }
        return stairs1(n - 1) + stairs1(n - 2);
    }
    // 补充题1：非递归方法
    public static int stairs2(int n){
        if (n < 1){
            return 0;
        }
        if (n == 1 || n == 2){
            return n;
        }
        int pPre = 1, pre = 2, cur = 0;
        for (int i = 3; i <= n; i++){
            cur = pPre + pre;
            pPre = pre;
            pre = cur;
        }
        return cur;

    }

    // 补充题2：递归方法
    public static int cow1(int n){
        if (n < 1){
            return 0;
        }
        if (n == 1 || n == 2 || n == 3){
            return n;
        }
        return cow1(n - 1) + cow1(n - 3);
    }
    // 补充题2：非递归方法
    public static int cow2(int n){
        if (n < 1){
            return 0;
        }
        if (n == 1 || n == 2 || n == 3){
            return n;
        }
        int ppPre = 1, pPre = 2, pre = 3, cur = 0;
        for (int i = 4; i <= n; i++){
            cur = ppPre + pre;
            ppPre = pPre;
            pPre = pre;
            pre = cur;
        }
        return cur;
    }


    public static void main(String[] args) {
        // 斐波拉契数列（递归）
        System.out.println(fib1(5));
        // 斐波拉契数列（非递归）
        System.out.println(fib2(7));

        // 补充题1：递归实现
        System.out.println(stairs1(5));
        // 补充题1：非递归实现
        System.out.println(stairs2(5));

        // 补充题2：递归实现
        System.out.println(cow1(5));
        // 补充题2：非递归实现
        System.out.println(cow2(5));
    }

}


























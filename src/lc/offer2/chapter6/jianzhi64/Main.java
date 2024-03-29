package lc.offer2.chapter6.jianzhi64;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出:6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出:45
 *
 *
 * 限制：
 *
 * 1 <= n<= 10000
 *
 * */

class Solution {
    public int sumNums(int n) {
        // && 短路与
        boolean flag = n > 0 && (n += sumNums(n-1)) > 0;
        // n == 1 || (n += sumNums(n-1)) > 0
        return n;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumNums(100));
    }
}

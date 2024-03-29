package lc.offer2.chapter6.jianzhi62;


/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出:3
 *
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出:2
 *
 * 限制：
 *
 * 1 <= n<= 10^5
 * 1 <= m <= 10^6
 *
 * */

class Solution {
    // 假设我们最好剩余的数字是N。
    //
    // 执行完“删除第3个元素”的操作后，N在新数组中的位置P的意义表示，在新数组中，N前面有还有P个元素。
    // 那么，在当前数组中，N前面一定有“P+3”个元素。 明白了这一点即可开始倒推。
    //
    // 最后一轮：当前有1个元素。N的位置是0；
    //
    // 倒数第2轮：当前有2个元素。已知在执行完“删除第i个元素”后，N在新数组中的位置是0。
    // 则说明在本轮中N前面有0+3=3个元素，所以N的位置是3，然而本轮只有2个元素，所以N的实际位置是（0+3）%2 = 1；
    //
    // 倒数第3轮：当前有3个元素。已知在执行完“删除第三个元素”后，N’在新数组中的位置是1。
    // 说明此刻，N前面有1+3=4个元素，所以N的位置是4。而当前数组只有3个元素，故实际位置是（1+3）%3=1；
    public int lastRemaining(int n, int m) {
        // 递推公式：
        // f(n,m) = 0                    (n = 0)
        // f(n,m) = ( f(n-1,m) + m ) % n (n > 1)
        int f = 0; // 记录上一次的结果，最后一轮是0
        // 从倒数第二轮开始推
        for (int i = 2; i <= n; i++) {
            f = (f + m) % i;
        }
        return f;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(88,10));
    }
}

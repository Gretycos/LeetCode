package lc.daily.date2209.Q667;


/**
 * 给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
 *
 * 假设该列表是 answer =[a1, a2, a3, ... , an] ，
 * 那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数。
 * 返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, k = 1
 * 输出：[1, 2, 3]
 * 解释：[1, 2, 3] 包含 3 个范围在 1-3 的不同整数，并且 [1, 1] 中有且仅有 1 个不同整数：1
 *
 *
 * 示例 2：
 *
 * 输入：n = 3, k = 2
 * 输出：[1, 3, 2]
 * 解释：[1, 3, 2] 包含 3 个范围在 1-3 的不同整数，并且 [2, 1] 中有且仅有 2 个不同整数：1 和 2
 *
 *
 * 提示：
 *
 * 1 <= k < n <= 10^4
 *
 * */

class Solution {
    // k == 1，顺序排列，只有一种差值
    // k == n-1，[1,n,2,n-1,3,...]排列，相邻的差从n-1开始，依次递减1
    // 一般情况，前半部份相邻差为1，后半部份相邻差从k递减至1：[1,2,...,n-k,n,n-k+1,n-1,...,]
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int idx = 0;
        // 顺序，只有1种差值
        for (int i = 1; i < n - k; i++){
            res[idx++] = i;
        }
        // 乱序，有k-1种差值
        for (int i = n - k, j = n; idx < n; i++, j--){
            res[idx++] = i;
            if (idx < n){
                res[idx++] = j;
            }
        }
        return res;
    }
}
public class Main {
}

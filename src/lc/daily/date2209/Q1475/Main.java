package lc.daily.date2209.Q1475;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个数组prices，其中prices[i]是商店里第i件商品的价格。
 *
 * 商店里正在进行促销活动，如果你要买第i件商品，那么你可以得到与 prices[j] 相等的折扣，
 * 其中j是满足j > i且prices[j] <= prices[i]的最小下标，如果没有满足条件的j，你将没有任何折扣。
 *
 * 请你返回一个数组，数组中第i个元素是折扣后你购买商品 i最终需要支付的价格。
 *
 *
 *
 * 示例 1：
 *
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 * 示例 2：
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：[1,2,3,4,5]
 * 解释：在这个例子中，所有商品都没有折扣。
 * 示例 3：
 *
 * 输入：prices = [10,1,1,6]
 * 输出：[9,0,1,6]
 *
 *
 * 提示：
 *
 * 1 <= prices.length <= 500
 * 1 <= prices[i] <= 10^3
 *
 * */

class Solution {
    // T:O(n^2), S: O(1)
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            int discount = 0;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] <= prices[i]){
                    discount = prices[j];
                    break;
                }
            }
            prices[i] -= discount;
        }
        return prices;
    }

    // T:O(n), S:O(n)
    // 单调栈
    public int[] finalPrices2(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peekLast() > prices[i]){
                stack.removeLast();
            }
            res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peekLast();
            stack.addLast(prices[i]);
        }
        return res;
    }
}
public class Main {
}

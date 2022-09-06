package lc.daily.date2208.Q1464;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 *
 * 请你计算并返回该式的最大值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，
 * (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 * 示例 2：
 *
 * 输入：nums = [1,5,4,5]
 * 输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 * 示例 3：
 *
 * 输入：nums = [3,7]
 * 输出：12
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 *
 * */

class Solution {
    public int maxProduct(int[] nums) {
        // 最大，次大
        int max_0 = nums[0], max_1 = nums[1];
        if (max_0 < max_1){
            int t = max_0;
            max_0 = max_1;
            max_1 = t;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max_0){
                max_1 = max_0;
                max_0 = nums[i];
            }else if (nums[i] > max_1){
                max_1 = nums[i];
            }
        }

        return (max_0 - 1) * (max_1 - 1);
    }
}
public class Main {
}
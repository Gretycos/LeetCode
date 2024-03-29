package lc.daily.date2211.Q764;

import java.util.Arrays;

/**
 * 在一个 n x n 的矩阵grid中，除了在数组mines中给出的元素为0，其他每个元素都为1。
 * mines[i] = [xi, yi]表示grid[xi][yi] == 0
 *
 * 返回 grid 中包含1的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
 *
 * 一个k阶由1组成的 “轴对称”加号标志 具有中心网格grid[r][c] == 1，
 * 以及4个从中心向上、向下、向左、向右延伸，长度为k-1，由1组成的臂。
 * 注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入: n = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 * 示例 2：
 *
 *
 *
 * 输入: n = 1, mines = [[0, 0]]
 * 输出: 0
 * 解释: 没有加号标志，返回 0 。
 *
 *
 * 提示：
 *
 * 1 <= n <= 500
 * 1 <= mines.length <= 5000
 * 0 <= xi, yi< n
 * 每一对(xi, yi)都 不重复
 *
 * */

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row,n);
        }
        for (int[] mine : mines) {
            dp[mine[0]][mine[1]] = 0;
        }

        int res = 0;
        // left and right
        for (int i = 0; i < n; i++) {
            int preSum = 0;
            // left
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0){
                    preSum ++;
                }else{
                    preSum = 0;
                }
                dp[i][j] = Math.min(dp[i][j],preSum);
            }

            preSum = 0;
            // right
            for (int j = n - 1; j >= 0; j--) {
                if (dp[i][j] != 0){
                    preSum ++;
                }else{
                    preSum = 0;
                }
                dp[i][j] = Math.min(dp[i][j],preSum);
            }
        }

        // down and up
        for (int j = 0; j < n; j++) {
            int preSum = 0;
            // down
            for (int i = 0; i < n; i++) {
                if (dp[i][j] != 0){
                    preSum ++;
                }else{
                    preSum = 0;
                }
                dp[i][j] = Math.min(dp[i][j],preSum);
            }

            preSum = 0;
            // up
            for (int i = n - 1; i >= 0; i--) {
                if (dp[i][j] != 0){
                    preSum ++;
                }else{
                    preSum = 0;
                }
                dp[i][j] = Math.min(dp[i][j],preSum);
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
public class Main {
}

package lc.daily.date2207.Q1260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 m 行 n列的二维网格grid和一个整数k。你需要将grid迁移k次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j]的元素将会移动到grid[i][j + 1]。
 * 位于grid[i][n- 1] 的元素将会移动到grid[i + 1][0]。
 * 位于 grid[m- 1][n - 1]的元素将会移动到grid[0][0]。
 * 请你返回k 次迁移操作后最终得到的 二维网格。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 **/

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List res;
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int pos = (i * n + j + k) % (m * n);
                map[pos / n][pos % n] = grid[i][j];
            }
        }
        res = Arrays.asList(map);
        return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                {1},
                {2},
                {3},
                {4},
                {7},
                {6},
                {5}
        };
        int k = 23;
        System.out.println(solution.shiftGrid(grid,k));
    }
}

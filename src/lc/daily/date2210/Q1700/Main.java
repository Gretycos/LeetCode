package lc.daily.date2210.Q1700;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字0和1表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个栈里，每一轮：
 *
 * 如果队列最前面的学生喜欢栈顶的三明治，那么会拿走它并离开队列。
 * 否则，这名学生会放弃这个三明治并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 *
 * 给你两个整数数组students 和sandwiches，其中sandwiches[i]是栈里面第i个三明治的类型（i = 0是栈的顶部），
 * students[j]是初始队列里第j名学生对三明治的喜好（j = 0是队列的最开始位置）。
 * 请你返回无法吃午餐的学生数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：students = [1,1,0,0], sandwiches = [0,1,0,1]
 * 输出：0
 * 解释：
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,0,0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,0,1,1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [0,1,1]，三明治栈为 sandwiches = [1,0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,1,0]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1,0]，三明治栈为 sandwiches = [0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1]，三明治栈为 sandwiches = [1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = []，三明治栈为 sandwiches = []。
 * 所以所有学生都有三明治吃。
 *
 *
 * 示例 2：
 *
 * 输入：students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= students.length, sandwiches.length <= 100
 * students.length == sandwiches.length
 * sandwiches[i]要么是0，要么是1。
 * students[i]要么是0，要么是1。
 *
 * */
class Solution {
    // 计数
    // 只要栈顶元素还在队列中存在，队列通过轮转一定能找到栈顶元素
    public int countStudents(int[] students, int[] sandwiches) {
        int circle = 0, square = 0;
        for (int student : students) {
            square += student;
        }
        circle = students.length - square;
        for (int sandwich : sandwiches) {
            // 队列中还有
            if (sandwich == 0 && circle > 0){
                circle--;
            }else if (sandwich == 1 && square > 0){
                square--;
            }else{ // 队列中没有该元素
                break;
            }
        }
        return circle + square;
    }

    // 栈模拟
    public int countStudents2(int[] students, int[] sandwiches) {
        Deque<Integer> queue = new ArrayDeque<>();
        int stack_p = 0;
        for (int student : students) {
            queue.addLast(student);
        }
        int times = 0;
        while (!queue.isEmpty()){
            if (sandwiches[stack_p] == queue.getFirst()){
                stack_p++;
                queue.removeFirst();
                times = 0;
            }else{
                queue.addLast(queue.removeFirst());
                if (++times == queue.size()){
                    break;
                }
            }
        }
        return queue.size();
    }
}


public class Main {
}

package lc.offer2.chapter6.jianzhi58_2;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *  
 *
 * 限制：
 *
 * 1 <= k < s.length <= 10000
 *
 * */

class Solution {


    private void reverse(StringBuilder sb, int start, int end){
        while(start < end){
            char t = sb.charAt(start);
            sb.setCharAt(start++,sb.charAt(end));
            sb.setCharAt(end--,t);
        }
    }

    // 底层
    // 三次反转
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverse(sb,0,n-1);
        reverse(sb,n,s.length()-1);
        return sb.reverse().toString();
    }

    // 偷懒
    public String reverseLeftWords2(String s, int n) {
        return s.substring(n).concat(s.substring(0,n));
    }
}


public class Main {
}

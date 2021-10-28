package leet.stack.middel;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/remove-k-digits/
 *
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字
 *
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219
 *
 * 输入：num = "10200", k = 1
 * 输出："200"
 *
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 */
public class RemoveKdigits {

    public static void main(String[] args) {
        String ss = "1234567890";
        int k = 9;
        System.out.println(removeKdigits(ss,k));
    }

    private static String removeKdigits(String num, int k){
        if (num == null || num.isEmpty() || k >= num.length())return "0";
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            while (!deque.isEmpty() && deque.peekLast() > num.charAt(i) && k>0){
                deque.pollLast();
                k--;
            }
            deque.add(num.charAt(i));
        }
        while (k>0){
            deque.pollLast();
            k--;
        }

        boolean needDeleteZero = true;
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            if (deque.peekFirst() =='0' && needDeleteZero){
                deque.pollFirst();
                continue;
            }
            needDeleteZero = false;
            sb.append(deque.pollFirst());
        }

        return sb.toString().isEmpty() ?"0":sb.toString();

    }

    //单调栈，满足栈里的元素，多少依次减少的。（k为条件，满足k且元素比栈定的大，移除）
//    public static String removeKdigits(String num, int k) {
//        if(num == null || num.isEmpty() || k >= num.length()) return "0";
//        Deque<Character> deque = new LinkedList<>();
//        for (int i = 0; i < num.length(); i++) {
//            char c = num.charAt(i);
//            if (!deque.isEmpty() && k>0 && deque.peekLast() > c){
//                deque.pollLast();
//                k--;
//            }
//            deque.offerLast(c);
//        }
//        //不够移除k位的从后面移除（栈已经是单调栈了）
//        for (int i = 0; i < k; ++i) {
//            deque.pollLast();
//        }
//        boolean needDeleteZero = true;
//        StringBuilder sb = new StringBuilder();
//        while (!deque.isEmpty()){
//            Character c =  deque.pollFirst();
//            if (c == '0' && needDeleteZero){
//                continue;
//            }
//            needDeleteZero = false;
//            sb.append(c);
//        }
//        return sb.toString().isEmpty()?"0":sb.toString();
//    }
}

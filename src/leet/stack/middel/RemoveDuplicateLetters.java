package leet.stack.middel;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        String ss = "cbacdcbc";
        System.out.println(removeDuplicateLetters(ss));
    }

    /**
     * https://leetcode-cn.com/problems/remove-duplicate-letters/
     * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     * @param s
     * @return
     */
//    public static String removeDuplicateLetters(String s) {
//        if (s== null || s.isEmpty())return s;
//        int length = s.length();
//        //都是小写字母，最毒只有26个，存储字母出现的最后位置
//        int[] lastIndex = new int[26];
//        for (int i = 0; i < length; i++) {
//            lastIndex[s.charAt(i) - 'a'] = i;
//        }
//        boolean[] visible = new boolean[26];
//        //arrayDeque 以数组的形式存储，具有良好的随机访问属性。（删除的时候需要每个元素都copy一份）
//        //LinkList 以链表形式存储，随机访问属性不好，但删除，插入属性较好，（删除的时候不需要每个都copy一份）
//        Deque<Character> deque = new ArrayDeque<>();
//
//        for (int i = 0; i < length; i++) {
//            int position = s.charAt(i) - 'a';
//            if (visible[position]){
//                continue;
//            }
//            //栈顶的元素比当前的元素大，并且后面还存在该元素
//            while (!deque.isEmpty() && deque.peekLast() > s.charAt(i) && lastIndex[deque.peekLast() - 'a']>i){
//                Character top = deque.removeLast();
//                visible[top - 'a'] = false;
//            }
//            deque.offerLast(s.charAt(i));
//            visible[position] = true;
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!deque.isEmpty()){
//            sb.append(deque.removeFirst());
//        }
//        return sb.toString();
//    }

    public static String removeDuplicateLetters(String s) {
        if (s== null || s.isEmpty())return s;
        int length = s.length();
        //都是小写字母，最毒只有26个，存储字母出现的最后位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < length; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        //arrayDeque 以数组的形式存储，具有良好的随机访问属性。（删除的时候需要每个元素都copy一份）
        //LinkList 以链表形式存储，随机访问属性不好，但删除，插入属性较好，（删除的时候不需要每个都copy一份）
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            if (deque.contains(s.charAt(i))){
                continue;
            }
            //栈顶的元素比当前的元素大，并且后面还存在该元素
            while (!deque.isEmpty() && deque.peekLast() > s.charAt(i) && lastIndex[deque.peekLast() - 'a']>i){
                Character top = deque.removeLast();
            }
            deque.offerLast(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}

package test;

import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/
 *
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s==null || s.isEmpty())return 0;
        String res = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!res.contains(c+"")){
                res += c;
                max = Math.max(max,res.length());
            }else{
                res = res.substring(res.indexOf(c+"")+1)+c;
            }
        }
        return max;
    }


}

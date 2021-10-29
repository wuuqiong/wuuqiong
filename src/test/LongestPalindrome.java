package test;

import sun.lwawt.macosx.CSystemTray;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 给你一个字符串 s，找到 s 中最长的回文子串
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String ss = "aaaa";
        System.out.println(longestPalindrome(ss));
    }
    private static String longestPalindrome(String ss) {
        //中心扩展算法
        if (ss.length() <2)return ss;
        int maxL = 1;
        int begin = 0;

        for (int i = 0; i < ss.length(); i++) {
            int ll = i-1;
            int rr = i+1;
            while (ll >=0 && rr<ss.length() && ss.charAt(ll) == ss.charAt(rr)){
                int len = rr -ll+1;
                //System.out.println("rr:" + rr +  "ll:" + ll +"and len" +len);
                if (len>maxL){
                    maxL = len;
                    begin = ll;
                }
                ll--;
                rr++;
            }
            ll = i;
            rr = i+1;
           // System.out.println("aarr:" + rr +  "aall:" + ll +" and len" +0);
            while (ll >=0 && rr<ss.length() && ss.charAt(ll) == ss.charAt(rr)){
                int len = rr -ll+1;
                //System.out.println("rr:" + rr +  "ll:" + ll +"and len" +len);
                if (len >maxL){
                    maxL = len;
                    begin = ll;
                }
                ll--;
                rr++;
            }
        }
        return ss.substring(begin,begin+maxL);

    }
//暴力接解法
//    public static String longestPalindrome(String s) {
//        if (s == null || s.length() < 2) return s;
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                System.out.println("start; " + start);
//                end = i + len / 2;
//                System.out.println("i ; " + i + " len  " + len);
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    public static int expandAroundCenter(String s, int left, int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            --left;
//            ++right;
//        }
//        return right - left - 1;
//    }


//    public static String longestPalindrome(String s) {
//        String res = "";
//        if (s.isEmpty() || s.length() ==1)return s;
//        int right = s.length();
//        for (int i = 0; i < s.length();) {
//            if (right <i) {
//                i++;
//                right = s.length() - 1;
//                continue;
//            }
//            if (res.length() > s.length() -i)break;
//            String curr = s.substring(i,right);
//            if (isPalindrome(curr)) {
//                if (curr.length() > res.length()){
//                    res = curr;
//                }
//                i++;
//                right = s.length();
//            }else{
//                right--;
//            }
//        }
//        return res;
//    }
//
//    private static boolean isPalindrome(String s) {
//        if (s.isEmpty()) return false;
//        int len = s.length() - 1;
//        int halfLen = s.length() / 2;
//        for (int i = 0; i < halfLen; i++) {
//            if (s.charAt(i) != s.charAt(len - i)) {
//                return false;
//            }
//        }
//        return true;
//    }

}

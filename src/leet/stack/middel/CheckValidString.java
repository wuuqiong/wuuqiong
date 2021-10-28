package leet.stack.middel;

import java.util.Stack;

public class CheckValidString {
    /**
     * https://leetcode-cn.com/problems/valid-parenthesis-string/
     * <p>
     * 给定一个只包含三种字符的字符串：（，）和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
     * <p>
     * 任何左括号 (必须有相应的右括号 )。
     * 任何右括号 )必须有相应的左括号 (。
     * 左括号 ( 必须在对应的右括号之前 )。
     * * 可以被视为单个右括号 )，或单个左括号 (，或一个空字符串。
     * 一个空字符串也被视为有效字符串
     *
     * @param
     * @return "(((((*)))**"
     * "((*)"
     */
    public static void main(String[] args) {
        String ss = "(((((*)))**";
        checkValidString(ss);
        int i = 0;


    }

    private static boolean checkValidString(String ss) {
        int max = 0;
        int min = 0;
        for (int i = 0; i < ss.length(); i++) {
            char c = ss.charAt(i);
            if (c == '(') {
                max++;
                min++;
            } else if (c == '*') {
                max++;
                min = Math.max(--min, 0);
            } else {
                max--;
                min = Math.max(--min, 0);
                if (max < 0) {
                    return false;
                }
            }
        }
        return min == 0;
    }

//    public static boolean checkValidString(String s) {
//        Stack<Integer> left = new Stack<>();
//        Stack<Integer> start = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '('){
//                left.push(i);
//            }else if (s.charAt(i) == '*'){
//                start.push(i);
//            }else{
//                if (left.isEmpty()){
//                    if (start.isEmpty())return false;
//                    start.pop();
//                }else{
//                    left.pop();
//                }
//            }
//        }
//        if (left.size() > start.size())return false;
//        while (!left.isEmpty()){
//            if (left.pop() > start.pop()) return false;
//        }
//        return true;
//    }
//    public static boolean checkValidString(String s) {
//        int n = s.length();
//        boolean[][] dp = new boolean[n][n];
//        for (int i = 0; i < n; i++) {
//            if (s.charAt(i) == '*') {
//                dp[i][i] = true;
//            }
//        }
//        for (int i = 1; i < n; i++) {
//            char c1 = s.charAt(i - 1), c2 = s.charAt(i);
//            dp[i - 1][i] = (c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*');
//        }
//        for (int i = n - 3; i >= 0; i--) {
//            char c1 = s.charAt(i);
//            for (int j = i + 2; j < n; j++) {
//                char c2 = s.charAt(j);
//                if ((c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*')) {
//                    dp[i][j] = dp[i + 1][j - 1];
//                }
//                for (int k = i; k < j && !dp[i][j]; k++) {
//                    dp[i][j] = dp[i][k] && dp[k + 1][j];
//                }
//            }
//        }
//        return dp[0][n - 1];
//    }


}

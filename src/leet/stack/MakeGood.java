package leet.stack;

/**
 * https://leetcode-cn.com/problems/make-the-string-great/
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 */
public class MakeGood {

    public static void main(String[] args) {
        String s = "s";
        System.out.println(makeGood(s));
    }


    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (top>=0 && Math.abs(sb.charAt(top)-s.charAt(i))==32){
                sb.deleteCharAt(top);
                top -- ;
            }else{
                sb.append(s.charAt(i));
                top++;
            }
        }
        return sb.toString();
    }
}

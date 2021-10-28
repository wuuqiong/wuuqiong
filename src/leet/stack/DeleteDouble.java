package leet.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class DeleteDouble {
    static String ss = "abbaca";

    public static void main(String[] args) {
        System.out.println(removeDuplicates(ss));
    }


//    public static String removeDuplicates(String s) {
//        String res = "";
//        Stack<Character> stack = new Stack<>();
//        for (int i = s.length()-1; i >=0; i--) {
//            Character character = s.charAt(i);
//            boolean add = true;
//            if (!stack.isEmpty()){
//                if (stack.peek() == character) {
//                    add =false;
//                    stack.pop();
//                }
//            }
//            if (add){
//                stack.push(character);
//            }
//        }
//        while (!stack.isEmpty()){
//            res+=stack.pop();
//        }
//        return res;
//    }

    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int top = -1;//记录角标位置
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && sb.charAt(top) == ch) {//top 大于0了，说明已添加了字符串了。如果最顶层的字符串与当前的一样，需要删除。
                sb.deleteCharAt(top);
                --top;
            } else {
                sb.append(ch);//添加不重复的字符串
                top++;//角标位置+1
            }
        }
        return sb.toString();
    }
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int i=0;
        if (i == target.length){
            return res;
        }
        for (int j = 1; j <n; j++) {
            if (target[0] == j){
                res.add("push");
                i++;
            }else {
                res.add("push");
                res.add("pop");
            }
        }
        return res;
    }
}


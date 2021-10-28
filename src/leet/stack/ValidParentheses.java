package leet.stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */

import java.util.*;

/**
 * stack
 * LinkedList
 * Deque
 */
public class ValidParentheses {
    //Deque

    private boolean solution(String s){
        if (s.isEmpty())return true;
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> match = new HashMap<Character, Character>(){
            {
                put(')','(');
                put(']','[');
                put('}','{');
            }
        };
        for (Character c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{' ){
              stack.push(c);
            }else{
                if (stack.isEmpty() || match.get(c)!=stack.poll()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.solution("{}}"));
    }

}

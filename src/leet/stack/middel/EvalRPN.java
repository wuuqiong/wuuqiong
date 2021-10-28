package leet.stack.middel;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class EvalRPN {

    public static void main(String[] args) {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
       System.out.println( evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String c:tokens) {
            if (c.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b+a);
            }else if (c.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }else if (c.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b*a);
            }else if (c.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);

            }else{
                int integer = Integer.valueOf(c);
                stack.push(integer);
            }
        }
        return stack.peek();
    }
}

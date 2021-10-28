package leet.stack.middel;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 */
public class Calculate {

    public static void main(String[] args) {
        String S = "14 / 3-2";
        System.out.println("bbb:" +  calculate1(S));
    }


    public static int calculate(String s) {
        int length = s.length();
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            //最后一个肯定是数字，防止!Character.isDigit(s.charAt(i)) 所以增加了 ||i == length - 1
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' '|| i == length - 1) {   // && i!=length-1
                System.out.println(" num: "+num);
                switch (sign) {
                    case '+':
                        stack.push(num);
                        System.out.println(" +: "+num);
                        break;
                    case '-':
                        stack.push(-num);
                        System.out.println(" -: "+num);
                        break;
                    case '*':
                        int n = stack.pop() * num;
                        System.out.println(" *: "+n);
                        stack.push(n);
                        break;
                    default:
                        int m= stack.pop() / num;
                        stack.push(m);
                        break;
                }
                num = 0;
                sign = s.charAt(i);
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res+=stack.pop();
        }


        return res;
    }

    public static int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int num = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')continue;
            if (Character.isDigit(c)){
                num = num*10 + c -'0';
                System.out.println("aaaa:" + num);
            }
            if (!Character.isDigit(c) || i == s.length()-1){
                if (stack.isEmpty()){
                    System.out.println("cccc:" + num);
                    stack.push(num);
                    continue;
                }
                switch (c){
                    case '+':
                        stack.push(num);
                        System.out.println("dddd:" +num);
                        break;
                    case '-':
                        stack.push(-num);
                        System.out.println("eeeee:" +-num);
                        break;
                    case '*':
                        int nn = stack.pop()*num;
                        System.out.println("ffff:" +nn);
                        stack.push(nn);
                        break;
                    case '/':
                        int mm = stack.pop()/num;
                        System.out.println("fffff:" +mm);
                        stack.push(mm);
                        break;
                }
                num=0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}

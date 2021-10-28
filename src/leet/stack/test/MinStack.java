package leet.stack.test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/
 */
public class MinStack {
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(x);//最小值
        }else{
            int min = Math.min(getMin(),x);
            stack.push(min);
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack.get(stack.size()-2);
    }
}

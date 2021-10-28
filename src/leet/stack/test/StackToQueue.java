package leet.stack.test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/submissions/
 */
public class StackToQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public StackToQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    public void push(int x) {
        in.push(x);
    }
    public int pop() {
        if (out.isEmpty()){
            fillOutStack();
        }
        return out.pop();
    }
    public int peek() {
        if (out.isEmpty()){
            fillOutStack();
        }
        return out.peek();
    }
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void fillOutStack(){
        while (!in.isEmpty()){
            out.push(in.pop());  //填充out数据的时候，把in的数据全部取出来
        }
    }
}

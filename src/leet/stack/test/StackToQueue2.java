package leet.stack.test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/submissions/
 */
public class StackToQueue2 {
    Stack<Integer> in;
    Stack<Integer> out;//Deque 双端队列

    public StackToQueue2(Stack<Integer> in, Stack<Integer> out) {
        in = new Stack<>();
        out = new Stack<>();

    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty() && in.isEmpty()){
            return -1;
        }
        if (out.isEmpty()){
            fillOutData();
        }
       return out.pop();
    }

    private void fillOutData(){
        while (!in.isEmpty()){
            out.push(in.pop());
        }
    }
}

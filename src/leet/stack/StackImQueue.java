package leet.stack;

import java.util.Stack;

public class StackImQueue {

    /**
     * https://leetcode-cn.com/problems/implement-queue-using-stacks/
     * @param args
     */
    public static void main(String[] args) {
        StackImQueue stackImQueue = new StackImQueue();
        stackImQueue.push(1);
        stackImQueue.push(2);
        System.out.println(stackImQueue.peek());
        System.out.println(stackImQueue.pop());
        System.out.println(stackImQueue.empty());
    }


    Stack<Integer> stack;
    public StackImQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(x);
        }else{
            Stack<Integer> temp = new Stack<>();
            temp.push(x);
            for (int i = 0; i <= stack.size()-1; i++) {
                temp.push(stack.get(i));
            }
            stack.clear();
            stack = temp;
        }
    }
    public int pop() {
       return stack.pop();
    }

    public int peek() {
       return stack.peek();
    }
    public boolean empty() {
       return stack.isEmpty();
    }
}

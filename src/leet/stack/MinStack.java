package leet.stack;

import java.util.Stack;

//最小栈，在常数时间内检索到最小的栈O(1)

/**
 * https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {

//    Stack<Integer> dataStack;
//    Stack<Integer> minStack;
//
//    public MinStack() {
//        dataStack = new Stack<>();
//        minStack = new Stack<>();
//    }
//
//    public void push(int val) {
//        dataStack.push(val);
//        if (minStack.isEmpty() || minStack.peek() >= val){
//            minStack.push(val);
//        }
//    }
//
//    public void pop() {
//        int data = dataStack.pop();
//        if (data == minStack.peek()){
//            minStack.pop();
//        }
//    }
//
//    public int top() {
//        return dataStack.peek();
//    }
//
//    public int getMin() {
//        return minStack.peek();
//    }

    //84   18
    Stack<Integer> dataStack;

    public MinStack() {
        dataStack = new Stack<>();
    }

    public void push(int val) {
        if (dataStack.isEmpty() || getMin() >val){
            dataStack.push(val);
        }else{
            dataStack.push(dataStack.peek());
        }
        dataStack.push(val);
    }

    public void pop() {
        dataStack.pop();
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {

        return dataStack.get(dataStack.size()-2);
    }


}

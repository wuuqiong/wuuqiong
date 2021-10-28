package leet.stack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImStack {
    /**
     * https://leetcode-cn.com/problems/implement-queue-using-stacks/
     * @param args
     */
    public static void main(String[] args) {
        QueueImStack queueImStack = new QueueImStack();
        queueImStack.push(1);
        queueImStack.push(2);
        queueImStack.top();
        queueImStack.pop();
        queueImStack.empty();
    }


    private Queue<Integer> data;
    private Queue<Integer> temp;

    public QueueImStack() {
        data = new LinkedList<>();
        temp = new LinkedList<>();
    }

    public void push(int x) {
        if (data.isEmpty()) {
            temp.offer(x);
        } else {
            temp.offer(x);
            while (!data.isEmpty()) {
                temp.offer(data.poll());
            }
        }
        Queue<Integer> queue = temp;
        temp = data;
        data = queue;
        //这样会吧data的值也clean
//        data = temp;
//        temp.clear();
    }

    public int pop() {
        return data.poll();
    }

    public int top() {
        return data.peek();
    }

    public boolean empty() {
        return data.isEmpty();
    }

}

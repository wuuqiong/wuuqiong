package leet.stack.middel;

import leet.stack.data.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 两数相加 II
 *
 * 给你两个 非空 链表来代表两个非负888整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表
 *
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        while (l1.next!=null){
            deque1.add(l1.val);
            l1 = l1.next;
        }
        while (l2.next!=null){
            deque2.add(l2.val);
            l2 = l2.next;
        }
        int carry=0;
        ListNode node=null;
        while (!deque1.isEmpty() || !deque2.isEmpty() || carry>0){
            int a = deque1.isEmpty()?0:deque1.pollLast();
            int b = deque2.isEmpty()?0:deque2.pollLast();
            int sum = a+b+carry;
            carry = sum/10;
            ListNode curr = new ListNode(sum%10);
            curr.next = node;
            node = curr;//赋值当前节点，
        }
        return node;
    }

    private ListNode reverseList(ListNode node){
        if(node == null || node.next == null)return node;
        ListNode res = null;
        while (node!=null){
            ListNode nextTemp = node.next;
            node.next = res;
            res = node;
            node = nextTemp;
        }
        return res;
    }

}

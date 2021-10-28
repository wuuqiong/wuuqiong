package test;

import leet.stack.data.ListNode;

/**
 * 两数相加 II
 * <p>
 * 给你两个 非空 链表来代表两个非负888整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 */
public class AddTwoNumbers2 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4,new ListNode(9));

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6,new ListNode(4,new ListNode(9)));

        addTwoNumbers(listNode,listNode2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        l1 = reverseList(l1);
//        l2 = reverseList(l2);
        ListNode res = null;
        int carry=0;
        while (l1 != null || l2 != null || carry>0) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            System.out.println("a: " + a + " and b: " + b + " and carry:  " +carry);

            ListNode node = new ListNode((carry+a+b)%10);
            carry = (carry+a+b)/10;
            node.next = res;
            res = node;
            System.out.println("res: " + node.val);
        }
        return res;
    }


    private static ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode pre = null;
        while (node != null) {
            ListNode nextTemp = node.next;
            node.next = pre;
            pre = node;
            node = nextTemp;
        }
        return pre;
    }
}

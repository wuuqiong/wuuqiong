package leet.stack.test;

import leet.stack.data.ListNode;

public class IsPalindrome {

    /**
     * https://leetcode-cn.com/problems/aMhZSa/submissions/
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null)return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverseListNode(slow.next);
        boolean result = true;
        while (result && slow!=null){
            result = slow.val == head.val;
            head = head.next;
            slow = slow.next;
        }
        return result;
    }

    /**
     * 反转链表
     * @param node
     * @return
     */
    private ListNode reverseListNode(ListNode node){
        if(node == null || node.next == null)return node;
        ListNode pre = null;
        ListNode curr = node;
        while (curr!=null){
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTemp;
        }
        return pre;
    }

}

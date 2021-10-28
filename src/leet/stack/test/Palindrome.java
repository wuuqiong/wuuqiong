package leet.stack.test;

import leet.stack.data.ListNode;

import java.util.List;

public class Palindrome {

    //1->2->3->4
    public static void main(String[] args) {
        ListNode node333 = new ListNode(1);
        ListNode node33 = new ListNode(4,node333);
        ListNode node3 = new ListNode(-1,node33);
        ListNode node2 = new ListNode(-1,node3);
        ListNode node22 = new ListNode(4,node2);
        ListNode node1 = new ListNode(1,node22);

//        System.out.print(isPalindrome(node1));
    }

    public static boolean isPalindrome(ListNode head){
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverseLinkList(slow.next);
        boolean result = true;
        while (result && fast!=null){
            result = fast.val == head.val;
            fast = fast.next;
            head = head.next;
        }
        return result;
    }
    //pre->1->2->3->4
    private static ListNode reverseLinkList(ListNode node){
        if (node == null)return null;
        ListNode pre = null;
        ListNode curr = node;
        while (curr!=null){
            ListNode nextTemp = curr.next;//缓存下个节点
            curr.next = pre;//反转列表，因为这里反转了，所以上面要缓存一下下个节点
            pre = curr;//当前列表后移
            curr = nextTemp;
        }
        return pre;
    }


    //递归的方法反转 https://www.bilibili.com/video/BV1Pq4y1979x?p=83
    private static ListNode recursionLinkList(ListNode head) {
        if (head == null || head.next == null)return head;
        //往下走
        ListNode res = recursionLinkList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

}

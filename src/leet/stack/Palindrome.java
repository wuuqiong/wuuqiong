package leet.stack;

import leet.stack.data.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表只有一个的时候也是true
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class Palindrome {
    private static ListNode frontPointer;

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node22 = new ListNode(1);
        node1.next = node22;
        ListNode node2 = new ListNode(1);
        node22.next = node2;

        ListNode node3 = new ListNode(1);
        node2.next = node3;
        ListNode node4 = new ListNode(2);
        node3.next = node4;
//        System.out.println(isPalindrome1(node1));
//        System.out.println(isPalindrome(node1));
        System.out.println(isPalindrome3(node1));
//        isPalindrome3(node1);
    }


    //放进集合中，前后进行比较
    public static boolean isPalindrome1(ListNode head){
        if (head == null)return false;
        List vals = new ArrayList();
        while (head!=null){
            vals.add(head.val);
            head = head.next;
        }
        int front = 0;
        int back = vals.size() - 1;
        while (front < back){
            if (vals.get(front) == vals.get(back)) {
                front ++;
                back --;
            }else{
                return false;
            }
        }
        return true;
    }

    //快慢指针
    //快指针走两步，慢指针走一步
    public static boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转链表 slow.next
        fast = reverseLinkList(slow.next);
        System.out.println(fast);
        boolean result = true;
        while (result && fast!=null){
            result = head.val == fast.val;
            head = head.next;
            fast = fast.next;
        }
        return result;
    }

    /** ** ** ** ** ** ** 反转链表** ** ** ** ** ** ** ** */
    //迭代方法反转  https://www.bilibili.com/video/BV1Mv411E7Mm?p=60
    private static ListNode reverseLinkList(ListNode head) {
        ListNode prev = null;//虚拟的前节点
        ListNode curr = head;//要反转的节点
        while (curr!=null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev =curr;
            curr = nextTemp;
        }
        return prev;
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

    //回文链表 递归实现 https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/

    /**
     * 递归实现 判断回文链表
     * @param head
     * @return
     */
    public static boolean isPalindrome3(ListNode head){
        frontPointer = head;
        return recursivelyCheck(frontPointer);
    }

    public static boolean recursivelyCheck(ListNode head){
        if (head !=null){
            //recursivelyCheck 负责入栈，到执行的head.next为空的的时候，返回true的时候。
            if (!recursivelyCheck(head.next)){ //head.next 为空的时候，就不执行这。否则返回的为当前的两个值。
                System.out.println("111入栈%%% " + head.val);
                return false;
            }
            //比较前后的值，如果不同直接返回false，
            if (head.val != frontPointer.val){
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
}

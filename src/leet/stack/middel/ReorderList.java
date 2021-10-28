package leet.stack.middel;

import leet.stack.data.ListNode;

/**
 * https://leetcode-cn.com/problems/reorder-list/submissions/
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode node1Temp = node1;
        while (node1Temp!=null){
            System.out.println("value: " + node1Temp.val);
            node1Temp = node1Temp.next;
        }
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(node1);

        ListNode node2Temp = node1;

        while (node2Temp!=null){
            System.out.println("value: " + node2Temp.val);
            node2Temp = node2Temp.next;
        }
    }


    public void reorderList(ListNode head) {

        ListNode middle = findMiddleListNode(head);
        //反转后部分的顺序
        ListNode afterwards = (reverseLinkList(middle.next));
        middle.next =null;//middle之后的值，只保留前半部分
        mergeList(head,afterwards);
    }

    private ListNode findMiddleListNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private void mergeList(ListNode forward, ListNode afterwards) {
        //因为要修改节点，所以先记录下
        ListNode f_next;
        ListNode a_next ;

        while (forward!=null && afterwards !=null){
            //因为要修改节点，所以先保持下当前的值
            f_next = forward.next;
            a_next = afterwards.next;

            forward.next = afterwards;
            forward = f_next;

            afterwards.next = forward;
            afterwards = a_next;
        }

    }

    private ListNode reverseLinkList(ListNode head){
        if (head==null ||head.next==null)return head;
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTemp;
        }
        return pre;
    }

}

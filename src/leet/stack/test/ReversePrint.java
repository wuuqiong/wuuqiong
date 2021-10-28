package leet.stack.test;

import leet.stack.data.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReversePrint {

    public static void main(String[] args) {

    }


    public static int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        reverseNote(head,list);
        int[] print = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            print[i] = list.get(i);
        }
        return print;
    }

    private static void reverseNote(ListNode head, List<Integer> list){
        if (head == null ||head.next==null){
            return;
        }
        reverseNote(head.next,list);
        list.add(head.val);
    }

}

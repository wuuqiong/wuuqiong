package aa;

import leet.stack.data.ListNode;
import leet.stack.data.TreeNode;

import java.util.*;

public class print {

    public static void main(String[] args) {
//        System.out.println("输入的行数");
//        Scanner scanner = new Scanner(System.in);
//        print(Integer.valueOf(scanner.next()));
//        ListNode node333 = new ListNode(1);
//        ListNode node33 = new ListNode(4, node333);
//        ListNode node3 = new ListNode(-1, node33);
//        ListNode node2 = new ListNode(-1, node3);
//        ListNode node22 = new ListNode(4, node2);
//        ListNode node1 = new ListNode(1, node22);
//        ListNode res = reverseLinkList(node1);
//        while (res != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }
//        System.out.println(dayOfYear("2003-03-01"));
//        System.out.println(dayOfTheWeek(15,8,1993));
//        System.out.println(isPalindrome(1011));
        int [] res = new int[]{30,20,150,100,40};
    }

//    private static void print(int n){
//        int begin = 1;
//        for (int i = 1; i <=n ; i++) {
//            for (int j = 1; j <=i; j++) {
//                System.out.print(begin++ + " ");
//            }
//            System.out.print("\n");
//        }
//    }

    private static ListNode reverseLinkList(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode pre = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 0000-00-00
    //i++,先运输再自加，先++，再参与运算
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        int[] amount = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {//闰年的条件
            ++amount[1];
        }
        for (int i = 0; i < month - 1; i++) {
            day += amount[i];
        }
        return day;
    }

    //1971 到 2100
    //1971年1月1日，星期五
    //"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    public String dayOfTheWeek(int day, int month, int year) {
        //1971年1月1日是Friday，所以%7 为0的时候是Thursday，所以String从Thursday开始
        String[] res = new String[]{"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
        int[] mouths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1971; i < year; i++) {//从1971年开始，i从1971开始，当前year不计算，
            if (isLeapYear(i)) {
                day += 366;
            } else {
                day += 365;
            }
        }
        if (isLeapYear(year)) {//当前year是否是闰年。闰年2月29天。
            ++mouths[1];
        }
        for (int i = 0; i < month - 1; i++) {//增加当前year的月的天
            day += mouths[i];
        }
        return res[day % 7];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }


    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int z = 0;
        int y = x;
        while (y != 0) {
            z = z * 10 + y % 10;
            y = y / 10;
        }
        return z == x;
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        order(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void order(TreeNode treeNode, List res) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(treeNode);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            res.add(node.val);
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }
    }

    /**
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return nums1;
        if (nums2 == null || nums2.length == 0) return nums2;
        Set set = new HashSet();
        for (int k : nums1) {
            for (int i : nums2) {
                if (k == i) {
                    set.add(i);
                    break;
                }
            }
        }
        int[] res1 = new int[set.size()];
        int index = -1;
        for (Object o : set) {
            res1[++index] = (int) o;
        }
        return res1;

//        List res = new ArrayList();
//
//        for (int i = 0; i < nums1.length; i++) {
//            set.add(nums1[i]);
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            if (set.contains(nums2[i])) {
//                res.add(nums2[i]);
//                set.remove(nums2[i]);
//            }
//        }
//        int[] res1 = new int[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            res1[i] = (int) res.get(i);
//        }
//        return res1;
    }

}

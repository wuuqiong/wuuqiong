package leet.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class GreaterElement {

    /**
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     *
     * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-greater-element-i
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     *
     */

    //1342
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//        Stack<Integer> stack = new Stack<Integer>();
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = len2-1; i>=0; i--) {
//            while (!stack.isEmpty() && nums2[i] >=stack.peek()){
//                stack.pop();
//            }
//            map.put(nums2[i],stack.isEmpty()? -1:stack.peek());
//            stack.push(nums2[i]);
//        }
//    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            boolean match = false;
            for (int j = 0; j < nums2.length; j++) {
                if (match){
                    if (nums2[j] > nums1[i]){
                        res[i] = nums2[j];
                        break;
                    }
                }
                if (nums1[i] == nums2[j]) {
                    match = true;
                }
            }
        }
        return res;

    }

    //从后面排
    private Map<Integer,Integer> helper(int[] nums){
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = nums.length-1; i>=0; i--) {
            while (!stack.isEmpty() && nums[i] >=stack.peek()){
                stack.pop();
            }
            map.put(nums[i],stack.isEmpty()? -1:stack.peek());
            stack.push(nums[i]);
        }
        return map;
    }

    private Map<Integer,Integer> helper1(int[] nums){
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() && nums[i] > stack.peek()){
                map.put(stack.pop(),nums[i]);
            }
            stack.push(nums[i]);
        }
        while (!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        return map;
    }
}

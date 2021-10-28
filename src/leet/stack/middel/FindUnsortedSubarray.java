package leet.stack.middel;


import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * 最短无序连续子数组
 */
public class FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,3};
        System.out.println(findUnsortedSubarray(nums));
    }
    //从左到右，遍历出不符合的
    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length==1)return 0;
        int left=-1;//无序开始的第一个角标
        int right = -1;//无序结束的第一个角标
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //right 从左边遍历，深层次找到最右边的数
            if (nums[i] < maxValue){
                right = i;
            }else{
                maxValue = nums[i];
            }
            //left 从右边遍历，深层次找到最左边的数
            if (nums[len - 1 -i] >minValue){
                left = len - 1 -i;
            }else {
                minValue = nums[len - 1 -i];
            }
        }
        System.out.println("left: " + left + " and right: " + right);
        //right ==-1 表示整个数组为有序的，返回0
        return right == -1?0:right - left +1;
    }


//    public static int findUnsortedSubarray(int[] nums) {
//        int n = nums.length;
//        int maxn = Integer.MIN_VALUE, right = -1;
//        int minn = Integer.MAX_VALUE, left = -1;
//        for (int i = 0; i < n; i++) {
//            if (maxn > nums[i]) {
//                right = i;
//            } else {
//                maxn = nums[i];
//            }
//            if (minn < nums[n - i - 1]) {
//                left = n - i - 1;
//            } else {
//                minn = nums[n - i - 1];
//            }
//        }
//        System.out.println("left: " + left + " and right: " + right);
//        return right == -1 ? 0 : right - left + 1;
//    }

    //[2,6,4,8,10,9,15]
//    public static int findUnsortedSubarray(int[] nums) {
//        if (nums==null || nums.length ==1 || isSorted(nums))return 0;
//        int[] temp = new int[nums.length];
//        System.arraycopy(nums,0,temp,0,nums.length);
//        Arrays.sort(temp);
//        int left = 0;
//        int right = nums.length-1;
//        while (nums[left] == temp[left]){
//            left++;
//        }
//        while (nums[right] == temp[right]){
//            right--;
//        }
//        return right-left+1;
//    }


    private  boolean isSorted(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]){
                return false;
            }
        }
        return true;
    }

}

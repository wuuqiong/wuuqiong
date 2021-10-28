package leet.stack.middel;

import leet.stack.data.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * 最大的二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树
 *
 *  3,2,1,6,0,5
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursion(nums,0,nums.length);
    }

    private TreeNode recursion(int[] nums,int left,int right){
        if (left == right)
            return null;
        int position = maxPosition(nums,left,right);
        TreeNode treeNode = new TreeNode(nums[position]);
        treeNode.left = recursion(nums,left,position);
        treeNode.right= recursion(nums,position+1,right);
        return treeNode;
    }

    private int maxPosition(int[] nums,int left,int right){
        int position =left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[position]){
                position = i;
            }
        }
        return position;
    }


    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = construct(nums, l, max_i);
        root.right = construct(nums, max_i + 1, r);
        return root;
    }
    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }
}

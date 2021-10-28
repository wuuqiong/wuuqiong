package leet.stack;

import leet.stack.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {
    //https://leetcode-cn.com/problems/increasing-order-search-tree/solution/di-zeng-shun-xu-cha-zhao-shu-by-leetcode-dfrr/
    private TreeNode resNode;
    public static TreeNode<Integer> node1;

    static {
        node1 = new TreeNode<>(5);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(6);
        node1.left = node2;
        node1.right = node3;

        TreeNode<Integer> node4 = new TreeNode<>(2);
        TreeNode<Integer> node5 = new TreeNode<>(4);
        node2.left = node4;
        node2.right = node5;

        TreeNode<Integer> node6 = new TreeNode<>(1);
        node4.left = node6;

        TreeNode<Integer> node7 = new TreeNode<>(8);
        node3.right = node7;

        TreeNode<Integer> node8 = new TreeNode<>(7);
        TreeNode<Integer> node9 = new TreeNode<>(9);
        node7.left = node8;
        node7.right = node9;

    }
    public  void main(String[] args) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorderTraversal(node1);
    }

    /**
     * 先中序遍历，然后在从遍历结果中组成新的结果
     * @param root
     */
    //中序
    public  void inorderTraversal(TreeNode<Integer> root){
        if (root == null)return ;
        inorderTraversal(root.left);
        resNode.right = root;
        resNode.left = null;
        resNode = resNode.right;
        inorderTraversal(root.right);
    }

    /**
     * 直接修改链表
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        // 在中序遍历的过程中修改节点指向
        resNode.right = node;
        node.left = null;
        resNode = node;

        inorder(node.right);
    }

}

package leet.stack.test;

import leet.stack.data.TreeNode;

public class IncreasingBST {

    private TreeNode temp;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode treeNode = new TreeNode(-1);
        temp = treeNode;
        inorder(root);
        return treeNode.right;
    }

    private void inorder(TreeNode node){
        if (node==null)return;
        inorder(node.left);
        temp.right = node;
        node.left = null;
        temp = node;//在原链表上直接修改
        //temp = temp.right;
        inorder(node.right);
    }

}

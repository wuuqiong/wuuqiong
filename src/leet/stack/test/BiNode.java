package leet.stack.test;

import leet.stack.data.TreeNode;

public class BiNode {
    private TreeNode resNode;
    public TreeNode convertBiNode(TreeNode root) {
        resNode = new TreeNode(-1);
        TreeNode temp = resNode;
        convert(root);
        return temp.right;
    }



    public void convert(TreeNode root){
        if (root==null)return;
        convert(root.left);
        root.left = null;
        resNode.right=root;
        resNode = resNode.right;
        convert(root.right);
    }
    //直接修改原链表
    public void convert2(TreeNode root){
        if (root==null)return;
        convert(root.left);
        root.left = null;
        resNode.right=root;
        resNode = root;
        convert(root.right);
    }
}

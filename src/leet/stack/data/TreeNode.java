package leet.stack.data;

/**
 * Definition for a binary tree node.
 */

public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    TreeNode() {
    }

    public TreeNode(T val) {
        this.val = val;
    }

    TreeNode(T val,  TreeNode<T> left,  TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
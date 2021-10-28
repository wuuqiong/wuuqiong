package leet.stack.middel;

import leet.stack.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Flatten {
    TreeNode prev1 = new TreeNode(-1);

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        TreeNode prev = new TreeNode(-1);// 这个是引入了一个新的treenode
        for (int i = 1; i < list.size(); i++) {//从1开始，表示curr为第一个。
            TreeNode pre = list.get(i-1);  //这个表示为第0个，不引入新的treenode，达到从原treenode上修改
            TreeNode curr = list.get(i);
            pre.left = null;
            pre.right = curr;
        }
    }


    private void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

//    private void preOrderWithStack(TreeNode root){
//        TreeNode node = root;
//        Stack<TreeNode> stack = new Stack<>();
//        List<TreeNode> list = new ArrayList<>();
//        while (node != null ||!stack.isEmpty()){
//            while (node != null) {
//                list.add(node);
//                stack.push(node);
//                node = node.left;
//            }
//            node = stack.pop();
//            node = node.right;
//        }
//    }

    private void preOrderWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //设置前面（prev的赋值放到后面去了）的node的左右节点的值，
            if (prev!=null){
                prev.left = null;
                prev.right = node;
            }

            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
            prev = node;
        }
    }
}

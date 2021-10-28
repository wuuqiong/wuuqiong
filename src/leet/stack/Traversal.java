package leet.stack;


import leet.stack.data.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *            23
 *           /  \
 *          34  21
 *         /    /  \
 *        99   45  60
 *       /  \
 *      77  90
 *  中序遍历，根在中，从左到右 ----> 左根右  77, 99, 90, 34, 23, 45, 21, 60
 *  前序遍历，根在前，从左到右 ----> 根左右
 *  后序遍历，根在后，从左到右 ----> 左右根
 *  https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Traversal {
    public static TreeNode<Integer> node1;

    static {
        node1 = new TreeNode<>(23);
        TreeNode<Integer> node2 = new TreeNode<>(34);
        TreeNode<Integer> node3 = new TreeNode<>(21);
        node1.left = node2;
        node1.right = node3;

        TreeNode<Integer> node4 = new TreeNode<>(99);
        TreeNode<Integer> node5 = new TreeNode<>(77);
        TreeNode<Integer> node6 = new TreeNode<>(90);
        node2.left = node4;
        node4.left = node5;
        node4.right = node6;

        TreeNode<Integer> node7 = new TreeNode<>(45);
        TreeNode<Integer> node8 = new TreeNode<>(60);
        node3.left = node7;
        node3.right = node8;
    }

    public static void main(String[] args) {
        System.out.println("中序遍历结果：" + inorderTraversal(node1));
        System.out.println("前序遍历结果：" + preTraversal(node1));
        System.out.println("后序遍历结果：" + postTraversal(node1));
        List<Integer> inRes = new ArrayList<>();
        inorderRecursion(node1,inRes);
        System.out.println("中序遍历递归结果：" + inRes);

        List<Integer> preRes = new ArrayList<>();
        preRecursion(node1,preRes);
        System.out.println("前序遍历递归结果：" + preRes);


        List<Integer> postRes = new ArrayList<>();
        postRecursion(node1,postRes);
        Collections.reverse(postRes);//反转结果
        System.out.println("后序遍历递归结果：" + postRes);
    }

    /**
     * 使用栈进行遍历
     */
    //中序
    public static List<Integer> inorderTraversal(TreeNode<Integer> root){
        List<Integer> list = new ArrayList<>();
        if (root == null)return list;
        Stack<TreeNode<Integer>> stack = new Stack<>(); //可以使用双向队列  Deque 栈的特点，先进后出，队列先进先出
        TreeNode<Integer> curr = root;
        //结束条件，stack为空，且curr也为空
        while (curr!=null || !stack.isEmpty()){
            //依次把左边的节点入栈
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode<Integer> node = stack.pop();
            list.add(node.val);
            curr = node.right; //右节点为空的时候，会取出Stack的下一个节点，即左节点的根节点，
        }
        return list;
    }
    //前序  根左右
    public static List<Integer> preTraversal(TreeNode<Integer> root){
        List<Integer> list = new ArrayList<>();
        if (root == null)return list;
        Stack<TreeNode<Integer>> stack = new Stack<>(); //
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode<Integer> node = stack.pop();
            if (node!=null){
                list.add(node.val);

                if (node.right!=null){
                    stack.add(node.right);
                }

                if (node.left!=null){
                    stack.add(node.left);
                }
            }
        }
        return list;
    }
    //后序（左右根）  先改编前序  根左右 -> 根右左->反转结果
    public static List<Integer> postTraversal(TreeNode<Integer> root){
        List<Integer> list = new ArrayList<>();
        if (root == null)return list;
        Stack<TreeNode<Integer>> stack = new Stack<>(); //
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode<Integer> node = stack.pop();
            if (node!=null){
                list.add(node.val);
                if (node.left!=null){
                    stack.add(node.left);
                }

                if (node.right!=null){
                    stack.add(node.right);
                }
            }
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 使用递归进行遍历
     */

    //中序
    public static void inorderRecursion(TreeNode<Integer> root,List<Integer> res) {
        if (root == null) return;
        inorderRecursion(root.left,res);//左
        res.add(root.val); //中
        inorderRecursion(root.right,res);//右
    }

    //前序  根左右
    public static void preRecursion(TreeNode<Integer> root,List<Integer> res) {
        if (root == null) return;
        res.add(root.val); //根
        preRecursion(root.left,res);//左
        preRecursion(root.right,res);//右
    }

    //后序  左右根
    public static void postRecursion(TreeNode<Integer> root,List<Integer> res) {
        if (root == null) return;
        res.add(root.val); //根
        postRecursion(root.right,res);//右
        postRecursion(root.left,res);//左
    }
}

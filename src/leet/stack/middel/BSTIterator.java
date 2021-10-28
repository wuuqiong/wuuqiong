package leet.stack.middel;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/er-cha-sou-suo-shu-die-dai-qi-by-leetcod-4y0y/
 */
public class BSTIterator {
    static int index=0;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        while (index<list.size()){
            System.out.println(list.get(index++));//先运算后自增
        }
    }


//    private int idx;
//    private List<Integer> arr;
//
//
//    public BSTIterator(TreeNode root) {
//        idx = 0;
//        arr = new ArrayList<Integer>();
//        inorderTraversal(root, arr);
//    }
//
//    public int next() {
//        return arr.get(idx++);
//    }
//
//    public boolean hasNext() {
//        return idx < arr.size();
//    }
//
//    private void inorderTraversal(TreeNode<Integer> root, List<Integer> arr) {
//        if (root == null) {
//            return;
//        }
//        inorderTraversal(root.left, arr);
//        arr.add(root.val);
//        inorderTraversal(root.right, arr);
//    }

//    private Stack<TreeNode> treeNodes;
//    private TreeNode<Integer> curr;
//
//    public BSTIterator(TreeNode root) {
//        treeNodes = new Stack<>();
//        curr =root;
//    }
//
//    public int next() {
//        //把所有的左节点都进栈
//        while (curr!=null){
//            treeNodes.push(curr);
//            curr = curr.left;
//        }
//        //当前的值，next 出栈
//        curr = treeNodes.pop();
//        int value = curr.val;
//        curr = curr.right;//next就是右节点，右节点为null，则进入treeNodes.pop();表示根节点
//        return value;
//    }
//
//    public boolean hasNext() {
//        return curr!=null && !treeNodes.isEmpty();
//    }

}

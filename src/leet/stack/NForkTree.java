package leet.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NForkTree {
    /**
     *https://leetcode-cn.com/problems/min-stack/
     */
    public static class Node{
        public int val;
        public List<Node> children;
        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        List<Node> rootChild = new ArrayList<>();
        Node root = new Node(1,rootChild);

        List<Node> nodeChild = new ArrayList<>();
        nodeChild.add(new Node(5));
        nodeChild.add(new Node(6));

        Node node = new Node(3,nodeChild);

        rootChild.add(node);
        rootChild.add(new Node(2));
        rootChild.add(new Node(4));
        root.children = rootChild;
        System.out.println(postorder(root));
    }
    //前序
    public static List<Integer> preorder(Node root) {
        List list = new ArrayList();
        if (root!=null){
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                Node node = stack.pop();
                list.add(node.val);
                if (node.children!=null){
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack.push(node.children.get(i));
                    }
                }
            }
        }
        return list;
    }
    //后序
    public static List<Integer> postorder(Node root) {
        List list = new ArrayList();
        if (root!=null){
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                Node node = stack.pop();
                list.add(node.val);
                if (node.children!=null){
                    for (int i = 0; i < node.children.size(); i++) {
                        stack.push(node.children.get(i));
                    }
                }
            }
        }
        Collections.reverse(list);
        return list;
    }
}

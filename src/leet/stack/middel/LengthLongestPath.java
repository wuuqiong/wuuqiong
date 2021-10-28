package leet.stack.middel;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 文件的最长绝对路径
 * \n换行符，\t制表符（子目录）
 */
public class LengthLongestPath {
    class Node {
        public int level;
        public int sum;

        public Node(int level, int sum) {
            this.level = level;
            this.sum = sum;
        }

    }

    public static void main(String[] args) {
        //System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

    /**
     * dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2
     * <p>
     * dir \tsubdir1 \t\tfile1.ext  \t\tsubsubdir1 \tsubdir2
     * <p>
     * <p>
     * dir  \tfile1.ext
     * dir/file1.ext
     * <p>
     * 3+11-1
     *
     * @param input
     * @return
     */

    public int lengthLongestPath(String input) {
        int res = 0;
        String[] splits = input.split("\n");
        Deque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < splits.length; ) {
            int tabs = splits[i].lastIndexOf("\t") + 1;//获取tabs的层级，没有为-1，有就从0开始，所以需要加1
            if (deque.isEmpty()) {
                if (splits[i].contains(".")) {
                    res = Math.max(res, splits[i].length());
                } else {
                    Node node = new Node(tabs, splits[i].length());
                    deque.push(node);
                }
                i++;
            } else {
                if (deque.peek().level + 1 == tabs) {
                    Node node = new Node(tabs, splits[i].length() - tabs + deque.peek().sum + 1);// \t长度为1，即为tabs的长度，+1为增加的"/"长度
                    if (splits[i].contains(".")) {
                        res = Math.max(res, node.sum);
                    } else {
                        deque.push(node);
                    }
                    i++;
                } else {
                    deque.pop();
                }
            }
        }
        return res;
    }

    //    public int lengthLongestPath(String input) {
//        String[] splits = input.split("\n");
//        Deque<Node> stack = new ArrayDeque<>();
//
//        int res = 0;
//        for(int i = 0; i < splits.length;){
//            int howManyTabs = countTab(splits[i]);
//
//            if(stack.isEmpty()){
//                if(splits[i].indexOf('.') != -1){
//                    res = Math.max(res, splits[i].length());
//                }else{
//                    Node newNode = new Node(howManyTabs, splits[i].length() - howManyTabs);
//                    stack.push(newNode);
//                }
//                i++;
//            }else{
//                Node peek = stack.peek();
//                //上下级关系
//                if(peek.level + 1 == howManyTabs){
//                    Node newNode = new Node(howManyTabs, splits[i].length() + peek.sum - howManyTabs + 1);
//                    if(splits[i].indexOf('.') != -1){
//                        res = Math.max(res, newNode.sum);
//                    }else{
//                        stack.push(newNode);
//                    }
//                    i++;
//                }else{
//                    stack.pop();
//                }
//            }
//        }
//
//        return res;
//    }
//
    public static int countTab(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; ; i++) {
            sb.append("\t");
            if (s.startsWith(sb.toString()))
                count++;
            else
                break;
        }

        return count;
    }
}

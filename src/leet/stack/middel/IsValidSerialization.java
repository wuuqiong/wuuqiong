package leet.stack.middel;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证二叉树的前序序列化
 *
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #
 *
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class IsValidSerialization {

    //"9,3,4,#,#,1,#,#,2,#,6,#,#"

//    public boolean isValidSerialization(String preorder) {
//        if (preorder == null || "#".equals(preorder)) return true;
//        int length = preorder.length();
//        int i = 0;
//        Deque<Integer> stack = new LinkedList<>();// link 存储适合删除，插入，array适合随机访问
//        //栈存储的是当前节点可存储的个数
//        stack.push(1);
//        //遇到数字减去1个房间增加两个房间，遇到#直接减去1个房间
//        while (i < length) {
//            //如果while循环没有结束，房间就没了，表示不是一个合法的树
//            if (stack.isEmpty())return false;
//            if (preorder.charAt(i) == ',') {
//                i++;
//            } else if(preorder.charAt(i)=='#'){
//                int top = stack.pop();
//                top--;
//                if (top==0){
//                    stack.pop();
//                }
//                i++;
//            }else {
//                while (i < length && preorder.charAt(i) != ',') {
//                    i++;
//                }
//                int top = stack.pop();
//                top--;
//                if (top > 0){
//                    stack.push(top);
//                }
//                stack.push(2);
//            }
//        }
//        //栈遍历完了，没有房间了表示为合法的树
//        return stack.isEmpty();
//    }

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || "#".equals(preorder)) return true;
        int length = preorder.length();
        int i = 0;
        int slots = 1;
        //遇到数字减去1个房间增加两个房间，遇到#直接减去1个房间
        while (i < length) {
            //如果while循环没有结束，房间就没了，表示不是一个合法的树
            if (slots == 0)return false;
            if (preorder.charAt(i) == ',') {
                i++;
            } else if(preorder.charAt(i)=='#'){
                slots--;
                i++;
            }else {
                //这里用while，可能存在个位以上的数字
                while (i < length && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++;
            }
        }
        //遍历完了，没房间了就是正确的
        return slots == 0;
    }
}

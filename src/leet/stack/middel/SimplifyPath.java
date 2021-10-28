package leet.stack.middel;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/simplify-path/
 */
public class SimplifyPath {
   static String test = "/home/foo";
    static String test1 = "/a/./b/../../c/";
    public static void main(String[] args) {
        System.out.println("res: " + simplifyPath(test1));
    }

//    public static String simplifyPath(String path) {
//        if (path == null)return "";
//        String[] paths = path.split("/");
//        String res="";
//        int lastIndex=-1;
//        for (String curr : paths) {
//            if (curr.equals(".") || curr.equals(""))continue;
//            if (curr.equals("..")) {
//                if (!"".equals(res)) {
//                    int index = res.lastIndexOf("/");
//                    res = res.substring(0, index);
//                }
//            } else {
//                res += "/" + curr;
//                lastIndex =res.length();
//            }
//        }
//        if (res.equals("")){
//            res = "/";
//        }
//        return res;
//    }

    public static String simplifyPath(String path) {
        if (path == null)return "";
        String[] paths = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (String curr : paths) {
            if (curr.equals(".") || curr.equals(""))continue;
            if (curr.equals("..")) {
                if (!stack.isEmpty())
                stack.pollLast();
            } else {
                stack.offer(curr);
            }
        }
        if (stack.isEmpty())return "/";
        String res="";
        while (!stack.isEmpty()){
            res+="/"+stack.pop();
        }
        return res;
    }

}

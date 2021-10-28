package leet.stack.middel;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/mini-parser/
 * 迷你语法分析器
 * <p>
 * 给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。
 * <p>
 * 列表中的每个元素只可能是整数或整数嵌套列表
 * <p>
 * 提示：你可以假定这些字符串都是格式良好的：
 * <p>
 * 字符串非空
 * 字符串不包含空格
 * 字符串只包含数字0-9、[、-、,、]
 * <p>
 * <p>
 * "[123,[456,[789]]]"
 * <p>
 * [123,[456,[789]]]
 */
public class Deserialize {

    public static class NestedInteger {
        public NestedInteger() {

        }

        public NestedInteger(int value) {
        }

        public boolean isInteger() {
            return false;
        }

        public Integer getInteger() {
            return 1;
        }

        public List<NestedIterator.NestedInteger> getList() {
            return new ArrayList<>();
        }

        public void add(NestedInteger ni) {

        }

        public void setInteger(int value) {

        }

    }

    //[123,[456,[789]]] 使用栈
//    public NestedInteger deserialize(String s) {
//        //"123"的情况
//        if (!s.startsWith("[")) return new NestedInteger(Integer.valueOf(s));
//        Deque<NestedInteger> deque = new ArrayDeque<>();
//        NestedInteger res = new NestedInteger();
//        deque.push(res);
//        int left = 1, right = 0;//用来截取数字
//        for (; right < s.length(); right++) {
//            Character c = s.charAt(right);
//            if (c.equals('[')) {
//                NestedInteger note = new NestedInteger();
//                deque.peek().add(note);//拿出栈定的结果，放值
//                left = right + 1;
//                deque.push(note);
//            } else if (c.equals(',') || c.equals(']')) {
//                if (right > left) {//去掉空字符串的情况
//                    int value = Integer.valueOf(s.substring(left, right));
//                    deque.peek().add(new NestedInteger(value));
//                }
//                if (c.equals(']')) {
//                    deque.pop();//栈定的NestedInteger 所有子结果都遍历好了
//                }
//                left = right + 1;
//            }
//        }
//        return res;
//    }
    // [123,[456,[789]]] 使递归

    public static void main(String[] args) {
        deserialize("[123,[456,[789]]]");
    }

    static int right = -1;
    static int left = 0;
    private static String ss;

    public static NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) return new NestedInteger(Integer.valueOf(s));
        ss = s;
        return getNested();
    }

    //123,[456,[789]]]
    private static NestedInteger getNested() {

        NestedInteger nestedInteger = new NestedInteger();
        while (right != ss.length() - 1) {
            right++;
            if (ss.charAt(right) == '[') {
                left = right + 1;
                nestedInteger.add(getNested());
            } else if (ss.charAt(right) == ',' || ss.charAt(right) == ']') {
                if (right > left) {
                    nestedInteger.add(new NestedInteger(Integer.valueOf(ss.substring(left, right))));
                }
                left = right + 1;
                if (ss.charAt(right) == ']') {
                    return nestedInteger;
                }
            }
        }
        return null;
    }
}

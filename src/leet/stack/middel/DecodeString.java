package leet.stack.middel;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/decode-string/
 * 3[a]2[bc]
 * 3[a2[c]]
 */


public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

//    public static String decodeString(String s) {
//        StringBuilder res = new StringBuilder();
//        int multi = 0;
//        LinkedList<Integer> stack_multi = new LinkedList<>();
//        LinkedList<String> stack_res = new LinkedList<>();
//        for(Character c : s.toCharArray()) {
//            if(c == '[') {
//                stack_multi.addLast(multi);
//                stack_res.addLast(res.toString());
//                multi = 0;
//                res = new StringBuilder();
//            }
//            else if(c == ']') {
//                StringBuilder tmp = new StringBuilder();
//                int cur_multi = stack_multi.removeLast();
//                for(int i = 0; i < cur_multi; i++){
//                    tmp.append(res);
//                }
//                res = new StringBuilder(stack_res.removeLast() + tmp);
//            }
//            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
//            else res.append(c);
//        }
//        return res.toString();
//    }

    public static String decodeString(String s) {
        int mun = 0;
        StringBuilder res = new StringBuilder();
        Deque<Integer> integerStack = new LinkedList<>();
        Deque<String> resStack = new LinkedList<>();
        for (Character c: s.toCharArray()){
            if (Character.isDigit(c)) {
                mun = mun * 10 + c - '0';
            } else if (c == '[') {
                integerStack.push(mun);
                resStack.push(res.toString());
                mun = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = integerStack.removeFirst();
                for (int i = 0; i < cur_multi; i++){
                    tmp.append(res);
                }
                res = new StringBuilder(resStack.removeFirst() + tmp);
            } else {
                res.append(c);
            }

        }
        return res.toString();
    }

//    int ptr;
//    public String decodeString(String s) {
//        LinkedList<String> stk = new LinkedList<String>();
//        ptr = 0;
//        //3[a]2[bc]
//        while (ptr < s.length()) {
//            char cur = s.charAt(ptr);
//            if (Character.isDigit(cur)) {
//                // 获取一个数字并进栈
//                String digits = getDigits(s);
//                stk.addLast(digits);
//            } else if (Character.isLetter(cur) || cur == '[') {
//                // 获取一个字母并进栈
//                stk.addLast(String.valueOf(s.charAt(ptr++)));
//            } else {
//                ++ptr;
//                LinkedList<String> sub = new LinkedList<String>();
//                while (!"[".equals(stk.peekLast())) {
//                    sub.addLast(stk.removeLast());
//                }
//                Collections.reverse(sub);
//                // 左括号出栈
//                stk.removeLast();
//                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
//                int repTime = Integer.parseInt(stk.removeLast());
//                StringBuffer t = new StringBuffer();
//                String o = getString(sub);
//                // 构造字符串
//                while (repTime-- > 0) {
//                    t.append(o);
//                }
//                // 将构造好的字符串入栈
//                stk.addLast(t.toString());
//            }
//        }
//
//        return getString(stk);
//    }
//
//    public String getDigits(String s) {
//        StringBuffer ret = new StringBuffer();
//        while (Character.isDigit(s.charAt(ptr))) {
//            ret.append(s.charAt(ptr++));
//        }
//        return ret.toString();
//    }
//
//    public String getString(LinkedList<String> v) {
//        StringBuffer ret = new StringBuffer();
//        for (String s : v) {
//            ret.append(s);
//        }
//        return ret.toString();
//    }

}

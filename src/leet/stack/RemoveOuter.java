package leet.stack;

/**
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 */
public class RemoveOuter {
    private static String s = "(()())(())(()(()))";

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses(s));
    }

    private static String removeOuterParentheses(String parentheses) {
        StringBuilder stringBuilder = new StringBuilder();
        if (parentheses != null) {
            int count = 0;
            for (int i = 0; i < parentheses.length(); i++) {
                Character c = parentheses.charAt(i);
                if (c == ')') count--;
                if (count > 0) stringBuilder.append(c);
                if (c == '(') count++;
            }
        }

        return stringBuilder.toString();
    }


//    public static String removeOuterParentheses(String s) {
//        String res = "";
//        Map<Character,Character> map = new HashMap<>();
//        map.put(')','(');
//        Stack<Character> stack = new Stack<>();
//        String temp = "";
//        for (int i = 0; i < s.length(); i++) {
//            temp+=s.charAt(i);
//            if (!stack.isEmpty()){
//                Character c = stack.peek();
//                if (map.get(s.charAt(i)) == c) {
//                    stack.pop();
//                    if (stack.isEmpty()){
//                        res= res+temp.substring(1,temp.length()-1);
//                        temp = "";
//                    }
//                }else{
//                    stack.push(s.charAt(i));
//                }
//            }else{
//                stack.push(s.charAt(i));
//            }
//
//        }
//        return res;
//    }
    //(()())(())(()(()))

    //(            ()())(())(()(()))   i=1
    //                                i=2 (
    //i=1 ()()
//    public static String removeOuterParentheses(String S) {
//        StringBuilder sb = new StringBuilder();
//        int level = 0;
//        for (char c : S.toCharArray()) {
//            if (c == ')') level--;
//            if (level >= 1) sb.append(c);
//            if (c == '(') level++;
//        }
//        return sb.toString();
//    }

}

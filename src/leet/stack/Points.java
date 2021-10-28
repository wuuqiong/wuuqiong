package leet.stack;

import java.util.Stack;

/**
 * 输入：ops = ["5","2","C","D","+"]
 * 输出：30
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "2" - 记录加 2 ，记录现在是 [5, 2]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * 所有得分的总和 5 + 10 + 15 = 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/baseball-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Points {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s:ops) {
            if (s.equals("+")){
                Integer first =  stack.pop();
                Integer second = stack.peek();
                stack.push(first);
                stack.push(first + second);
            }else if (s.equals("D")){
                stack.push(stack.peek() * 2);
            }else if (s.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }

}

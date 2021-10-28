package leet.stack;

import java.util.Stack;

public class MinOperations {
    /**
     * "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
     * "./" ：继续停留在当前文件夹。
     * "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/crawler-log-folder
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        String[] s = new String[]{"d1/","d2/","../","d21/","./"};

        System.out.println(minOperations(s));
    }

    public static int minOperations1(String[] logs) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../") ){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!logs[i].equals("./")){
                stack.push(1);
            }
        }
        return stack.size();
    }

    public static int minOperations(String[] logs) {

        int min=0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../") ){
                min = Math.max(0,min-1);
            }else if(!logs[i].equals("./")){
                min++;
            }
        }
        return min;
    }
}

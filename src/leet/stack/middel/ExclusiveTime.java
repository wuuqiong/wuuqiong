package leet.stack.middel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/exclusive-time-of-functions/
 * 函数的独占时间
 */
public class ExclusiveTime {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("0:start:0");
//        list.add("0:start:2");
        list.add("0:end:0");
//        list.add("1:start:7");
//        list.add("1:end:7");
//        list.add("0:end:8");
        //["0:start:0","1:start:2","1:end:5","0:end:6"]
        //["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
        //["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"]
//        ["0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"]
        //"0:start:0","0:end:0"
        System.out.println(Arrays.toString(exclusiveTime(1, list)));
    }


    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<String> stack = new Stack<>();
        long beginTime = 0;
        stack.push(logs.get(0));
        for (int i = 1; i < logs.size(); i++) {
            String log = logs.get(i);
            String[]opt = log.split(":");
            if (!stack.isEmpty()){
                String aa = stack.peek();
                String[] pop = aa.split(":");
                if (opt[1].equals("start")){
                    int addId = Integer.parseInt(pop[0]);
                    res[addId]+=Integer.parseInt(opt[2]) - beginTime;
                    beginTime = Integer.parseInt(opt[2]);
                    stack.push(log);
                }else{
                    int addId = Integer.parseInt(opt[0]);
                    res[addId]+=Integer.parseInt(opt[2])+1 - beginTime ;
                    beginTime = Integer.parseInt(opt[2])+1;
                    stack.pop();
                }
            }
        }
        return res;
    }

//    public static int[] exclusiveTime(int n, List<String> logs) {
//        Stack<Integer> stack = new Stack<>();
//        int[] res = new int[n];
//        String[] s = logs.get(0).split(":");
//        stack.push(Integer.parseInt(s[0]));
//        int i = 1, prev = Integer.parseInt(s[2]);
//        while (i < logs.size()) {
//            s = logs.get(i).split(":");
//            if (s[1].equals("start")) {
//                if (!stack.isEmpty()){
//                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
//                }
//                stack.push(Integer.parseInt(s[0]));
//                prev = Integer.parseInt(s[2]);
//            } else {
//                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
//                stack.pop();
//                prev = Integer.parseInt(s[2]) + 1;
//            }
//            i++;
//        }
//        return res;
//    }
}

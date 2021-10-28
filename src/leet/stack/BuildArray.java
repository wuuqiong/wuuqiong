package leet.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 *
 * https://leetcode-cn.com/problems/build-an-array-with-stack-operations/
 *
 */
public class BuildArray {


    public static void main(String[] args) {
        int [] ints = new int[]{2,3,4};
        int n  = 4;
        System.out.println(buildArray(ints,n));
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int top = 0;
        for (int i = 1; i <=n ; i++) {
            if (top > target.length-1){
                break;
            }
            //target 是递增的数组，当从n当中找到了一样的了，top就++
            if (target[top]==i) {
                list.add("Push");
                top++;
            }else{
                //与target中的数字不一样，先push 后pop
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }
}

package test;

import java.util.*;

public class TwoSum {

//    public int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];
//        List<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            int index = list.indexOf((target - list.get(i)));
//            if (index!=-1 && index!=i){
//                res[0] = i;
//                res[1] = index;
//                return res;
//            }
//        }
//        return res;
//    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
               return new int[]{i,map.get(target-nums[i])};
            }
            map.put(target-nums[i],i);
        }
        return new int[0];
    }

}

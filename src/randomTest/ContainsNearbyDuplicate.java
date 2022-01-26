package randomTest;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{99,99};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums,k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                if (i - index<=k){
                    return true;
                }else{
                    map.put(nums[i],i);
                }
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}

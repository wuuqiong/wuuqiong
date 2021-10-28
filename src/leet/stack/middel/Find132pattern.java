package leet.stack.middel;


import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列
 * 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j]
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false
 *
 * 由于本题中 nn 的最大值可以到 2 X 10^5
 * 枚举其中的 22 个下标时间复杂度为 O(n^2)，会超出时间限制
 */
public class Find132pattern {

    //132
    //[-2,1,2,-2,1,2]
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{-2,1,2,-2,1,2}));
        // -2,1,2,-2,1,2
    }

    //平衡树（红黑树？）维护一组数据，TreeMap
    //-2,1,2,-2,1,2
    private static boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<Integer>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }



    //平衡树（红黑树？）维护一组数据，TreeMap，2模式
  /*  private static boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n<3)return false;
        //维护左侧最小的值，默认为第0个位置
        int leftMin = nums[0];
        //维护右侧第二大的数据。
        TreeMap<Integer,Integer> rightAll = new TreeMap<>();
        //初始值，从第二位开始，前面两个数据分别为i，j
        for (int k = 2; k < n; k++) {
            //getOrDefault 返回map中key对应的value，
            //key num的值，value 出现key的次数
            rightAll.put(nums[k],rightAll.getOrDefault(nums[k],0)+1);
        }
        for (int i = 1; i < n-1; i++) {
            //leftMin的值，正好小于当前，符合 13，
            if(leftMin <nums[i]){
                //ceilingKey 返回大于或等于该key的value
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next!=null && next < nums[i]){//需要符合32模式
                    return true;
                }
            }
            leftMin = Math.min(leftMin,nums[i]);
            //i+1的位置为3模式，所以i+1再右侧出现的次数需要减1
            rightAll.put(nums[i + 1], rightAll.get(nums[i + 1]) - 1);
            //如果移除之后，value出现的次数为0，则移除该key
            if (rightAll.get(nums[i + 1]) == 0) {
                rightAll.remove(nums[i + 1]);
            }
        }
        return false;
    }*/
    //
    // 时间复杂度为O(n^2)超出了时间限制
//    public static boolean find132pattern(int[] nums) {
//        if (nums == null || nums.length < 3) return false;
//        Deque<Integer> deque = new LinkedList<>();
//        for (int i = 0; i < nums.length; ) {
//            int j = i;
//            deque.clear();
//            while (j < nums.length) {
//                if (deque.isEmpty() || deque.peekFirst() < nums[j]) {
//                    deque.offer(nums[j]);
//                }
//                j++;
//            }
//
//            if (deque.size()>2){
//                deque.pollFirst();
//                Deque<Integer> temp = new LinkedList<>();
//                while (!deque.isEmpty()) {
//                    while (!temp.isEmpty()  && temp.peekLast() <= deque.peekFirst()){
//                        temp.pollLast();
//                    }
//                    int add = deque.pollFirst();
//                    temp.add(add);
//                    if (temp.size() >1){
//                        return true;
//                    }
//                }
//            }
//
//            i++;
//        }
//        return false;
//    }


}

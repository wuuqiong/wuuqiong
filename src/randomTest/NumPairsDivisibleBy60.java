package randomTest;

/**
 * 1010
 * https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足 i < j 且有(time[i] + time[j]) % 60 == 0。
 * <p>
 * 提示：
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 * <p>
 * 解题过程：
 * 很容易想到双层循环，根据提示 1 <= time.length <= 6 * 104  ，使用双层循环，会超时
 */
public class NumPairsDivisibleBy60 {

    public static void main(String[] args) {
        int [] res = new int[]{30,20,150,100,40};
        System.out.println(numPairsDivisibleBy60(res));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        //最多只有60秒，创建一个60长度的数组
        int[] remainder = new int[60];
        for (int t : time) {
            ++remainder[t%60];
        }
        int count = 0;
        for (int i = 0; i < 60; i++) {
            //等于0，说明就没有出现过
            if (remainder[i] == 0)continue;
            if (i == 0 || i==30){//余数为0的，只能和余数为0的在一起，余数为30的只能和余数是30的在一起
                count += remainder[i] * (remainder[i] -1);
            }else{
                //余数为非0和非30的，例如余数为1，只能和59再一起。
                count += remainder[i] * remainder[60-i];
            }
        }
        //满足i>j，因为上述都计算过两次了。所以结果需要除2。
        //>> 带符号右移，>>> 不带符号的右移，高位补0
        return count >>> 1;
    }
}

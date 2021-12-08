package aa;

public class kLengthApart {

    public static void main(String[] args) {
        int[] aa = new int[]{1, 0, 0, 0, 1, 0, 0, 1};
        System.out.println(kLengthApart(aa, 2));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int position = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                System.out.println("i:  " + i + " and position " + position);
                if (i - position > k || position == -1) {
                    position = i;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

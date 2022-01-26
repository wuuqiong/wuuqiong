package randomTest;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 */
public class AreAlmostEqual {
//"bank"
//        "kanb"
    public static void main(String[] args) {
        String s1 = "bf";
        String s2 = "dd";

        System.out.println(areAlmostEqual(s1,s2));
    }


    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int length = s1.length();
        int first = -1;
        int second = -1;
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                if (first == -1){
                    first = i;
                }else if(second == -1){
                    second = i;
                }else{
                    return false;
                }
            }
        }
        return second>0 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }
}

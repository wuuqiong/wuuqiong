package aa;


public class Reverse {

    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(reverse(x));

    }
    public static int reverse (int x) {
        boolean negative = x <0;
        String res = "";
        if (negative){
            res+="-";
        }
        String xx = String.valueOf(x);
        for (int i = xx.length()-1; i >=(negative?1:0) ; i--) {
            res+=xx.charAt(i);
        }
        try {
            //不是整数抛出异常，
            return Integer.parseInt(res);
        }catch (Exception e){
            return 0;
        }
    }

//    private int anwser(int x){
//        int rev = 0;
//        while (x != 0) {
//            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
//                return 0;
//            }
//            int digit = x % 10;
//            x /= 10;
//            rev = rev * 10 + digit;
//        }
//        return rev;
//
//    }


}

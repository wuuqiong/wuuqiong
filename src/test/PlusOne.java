package test;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] ss = new int[]{9};
//        System.out.println(Arrays.toString(plusOne(ss)));
        plusOne(ss);
    }

//    public static int[] plusOne(int[] digits) {
//        int[] res = new int[digits.length];
//        boolean add= true;
//        for (int i = digits.length -1; i >=0 ; i--) {
//            if (add){
//                System.out.println((digits[i]+1)%10);
//                res[i] = (digits[i]+1)%10;
//                add = digits[i]+1>9;
//            }else{
//                res[i] = digits[i];
//            }
//        }
//        if (add){
//            int[] res1 = new int[digits.length + 1];
//            res1[0] = 1;
//            System.arraycopy(res,0,res1,1,res.length);
//            return res1;
//        }
//        return res;
//    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length -1; i >=0 ; i--) {
            digits[i]++;
            digits[i] = digits[i]%10;
            if (digits[i]!=0)return digits;
        }
        //所有的数都是9的情况
        int[] res = new int[digits.length +1];
        res[0] = 1;
        return res;
    }
}

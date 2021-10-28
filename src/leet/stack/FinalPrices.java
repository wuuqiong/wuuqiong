package leet.stack;

public class FinalPrices {

    public static void main(String[] args) {
        int[] prices = new int[]{10,1,1,6};
        for (int i = 0; i < prices.length; i++) {
            int[] finalPrices =  finalPrices(prices);
            System.out.println(finalPrices[i]);
        }
    }

    public static int[] finalPrices(int[] prices) {
        //最后一个永没有差价，
        for (int i = 0; i < prices.length-1; i++) {
            for (int k = i+1; k < prices.length; k++) {
                if (prices[i] >= prices[k]){
                    prices[i] = prices[i] - prices[k];
                    break;
                }
            }
        }
        return prices;
    }

    class Solution {
        public int[] finalPrices(int[] prices) {
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] <= prices[i]) {
                        prices[i] -= prices[j];
                        break;
                    }
                }
            }
            return prices;
        }
    }


//    public int[] finalPrices(int[] prices) {
//        int[] finalPrices = new int[prices.length];
//        for (int i = 0; i < prices.length; i++) {
//            if (i == prices.length-1){
//                finalPrices[i] = prices[i];
//            }else{
//                for (int k = i+1; k < prices.length; k++) {
//                    if (prices[i] >= prices[k]){
//                        finalPrices[i] = prices[i] - prices[k];
//                        break;
//                    }
//                    if (k == prices.length-1){
//                        finalPrices[i] = prices[i];
//                    }
//                }
//            }
//        }
//
//        return finalPrices;
//    }
}

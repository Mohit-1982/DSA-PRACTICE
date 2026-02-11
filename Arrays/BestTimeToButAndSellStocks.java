Leetcode - 121
  class Solution {
    public int maxProfit(int[] prices) {
        //Kadanes Algorithm
        int maxProfit = 0;
        int min = prices[0];
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            maxProfit = Math.max(maxProfit,prices[i] - min);
        }
        return maxProfit;
    }
}

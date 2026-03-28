GFG
  Brute : 
    class Solution {
    int minCost(int[] height) {
        return helper(height, 0);
    }
    int helper(int[] arr, int i) {
        if(i == arr.length - 1) return 0;
        int oneStair = Integer.MAX_VALUE;
        int twoStair = Integer.MAX_VALUE;
        if(i + 1 < arr.length) oneStair = Math.abs(arr[i] - arr[i + 1]) + helper(arr, i + 1);
        if(i + 2 < arr.length) twoStair = Math.abs(arr[i] - arr[i + 2]) + helper(arr, i + 2);
        return Math.min(oneStair, twoStair);
    }
}
Better : 
  class Solution {
    int minCost(int[] height) {
        int[] dp = new int[height.length];
        Arrays.fill(dp, -1);
        return helper(height, 0, dp);
    }
    int helper(int[] arr, int i, int[] dp) {
        if(i == arr.length - 1) return 0;
        if(dp[i] != -1) return dp[i];
        int oneStair = Integer.MAX_VALUE;
        int twoStair = Integer.MAX_VALUE;
        if(i + 1 < arr.length) oneStair = Math.abs(arr[i] - arr[i + 1]) + helper(arr, i + 1, dp);
        if(i + 2 < arr.length) twoStair = Math.abs(arr[i] - arr[i + 2]) + helper(arr, i + 2, dp);
        return dp[i] = Math.min(oneStair, twoStair);
    }
}
Optimal : 
  class Solution {
    int minCost(int[] height) {
        int[] dp = new int[height.length];
        //i --> length - 1 to 0
        dp[0] = 0;
        if(height.length > 1) dp[1] = Math.abs(height[0] - height[1]);
        for(int i = 2; i < height.length; i++) {
            int oneStair = Math.abs(height[i] - height[i - 1]) + dp[i - 1];
            int twoStair = Math.abs(height[i] - height[i - 2]) + dp[i - 2];
            dp[i] = Math.min(oneStair, twoStair);
        }
        return dp[height.length - 1];
    }
}
*Space Optimization : 
    class Solution {
    int minCost(int[] height) {
        int n = height.length;
        if(n == 1) return 0;
        if(n == 2) return Math.abs(height[0] - height[1]);
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = Math.abs(height[0] - height[1]);
        for(int i = 2; i < height.length; i++) {
            int oneStair = Math.abs(height[i] - height[i - 1]) + dp[1];
            int twoStair = Math.abs(height[i] - height[i - 2]) + dp[0];
            dp[2] = Math.min(oneStair, twoStair);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}

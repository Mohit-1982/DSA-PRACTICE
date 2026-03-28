Leetcode - 213
  Brute : 
    class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(helper(nums, 0, n - 1), helper(nums, 1, n));
    }
    public int helper(int[] nums, int i, int n) {
        if(i >= n) return 0;
        int taken = nums[i] + helper(nums, i + 2, n);
        int notTaken = helper(nums, i + 1, n);
        return Math.max(taken, notTaken);
    }
}
Better :
  class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        int[] dp1 = new int[n];
        Arrays.fill(dp, -1);
        Arrays.fill(dp1, -1);
        return Math.max(helper(nums, 0, n - 1, dp), helper(nums, 1, n, dp1));
    }
    public int helper(int[] nums, int i, int n, int[] dp) {
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        int taken = nums[i] + helper(nums, i + 2, n, dp);
        int notTaken = helper(nums, i + 1, n, dp);
        return dp[i] = Math.max(taken, notTaken);
    }
}
Optimal : 
  

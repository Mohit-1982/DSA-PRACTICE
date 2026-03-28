GFG
  Brute : 
    class Solution {
    public int findMaxSum(int arr[]) {
        return helper(arr, 0);
    }
    public int helper(int[] arr, int i) {
        if(i >= arr.length) return 0;
        int pick = arr[i] + helper(arr, i + 2);
        int skip = helper(arr, i + 1);
        return Math.max(pick, skip);
    }
}
Better : 
  class Solution {
    public int findMaxSum(int arr[]) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, 0, dp);
    }
    public int helper(int[] arr, int i, int[] dp) {
        if(i >= arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int pick = arr[i] + helper(arr, i + 2, dp);
        int skip = helper(arr, i + 1, dp);
        return dp[i] = Math.max(pick, skip);
    }
}
Optimal : 
  class Solution {
    public int findMaxSum(int arr[]) {
        if(arr.length == 1) return arr[0];
        if(arr.length == 2) return Math.max(arr[0], arr[1]);
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
        }
        return Math.max(dp[arr.length - 2], dp[arr.length - 1]);
    }
}
*Space Optimization : 
    class Solution {
    public int findMaxSum(int arr[]) {
        if(arr.length == 1) return arr[0];
        if(arr.length == 2) return Math.max(arr[0], arr[1]);
        int[] dp = new int[3];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++) {
            dp[2] = Math.max(arr[i] + dp[0], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[1];
    }
}

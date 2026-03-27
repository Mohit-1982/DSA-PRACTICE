GFG
  Brute : 
    class Solution {
    int countWays(int n) {
         if(n == 1 || n == 2) return n;
         return countWays(n - 1) + countWays(n - 2); 
    }
}
Better : 
  class Solution {
    int countWays(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }
    int helper(int n, int[] dp) {
        if(n == 1 || n == 2) return n;
        if(dp[n] != 0) return dp[n];
        int oneMinus = helper(n - 1, dp);
        int twoMinus = helper(n - 2, dp);
        int ans = oneMinus + twoMinus;
        dp[n] = ans;
        return ans; 
    }
}
Optimal : 
  class Solution {
    int countWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if(n >= 1) dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
*Space Optimization : 
    class Solution {
    int countWays(int n) {
        if(n == 0 || n == 1) return 1;
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}
class Solution {
    int countWays(int n) {
        int a = 1;
        int b = 1;
        int c = 1;
        for(int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

GFG
  Brute : 
    class Solution {
    int countStrings(int n) {
        int count = 0;
        int r1 = 1 << n;
        for(int i = 0; i < r1; i++) {
            int prev = 0;
            int e = i;
            boolean isPossi = true;
            while(e != 0) {
                int curr = (e & 1);
                if(curr == 1 && prev == 1) {
                    isPossi = false;
                    break;
                }
                prev = curr;
                e = e >> 1;
            }
            if(isPossi) count++;
        }
        return count;
    }
}
Better : 
  class Solution {
    int countStrings(int n) {
        if(n == 0) return 0;
        if(n == 1) return 2;
        int[] dp = new int[3];
        dp[0] = 2;
        dp[1] = 3;
        for(int i = 2; i < n; i++) {
            dp[2] = dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[1];
    }
}

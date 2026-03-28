Striver Sheet
  Brute : 
    import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] heights = {15, 4, 1, 14, 15};
        int k = 3;
        System.out.println(helper(heights, k, 0));
    }
    static int helper(int[] arr, int k, int i) {
        if(i == arr.length - 1) return 0;
        int min = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++) {
            if(i + j >= arr.length) break;
            int cost = Math.abs(arr[i] - arr[i + j]);
            min = Math.min(min, cost + helper(arr, k, i + j));
        }
        return min;
    }
}
Better : 
  import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] heights = {15, 4, 1, 14, 15};
        int k = 3;
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        System.out.println(helper(heights, k, 0, dp));
    }
    static int helper(int[] arr, int k, int i,int[] dp) {
        if(i == arr.length - 1) return 0;
        if(dp[i] != -1) return dp[i];
        int min = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++) {
            if(i + j >= arr.length) break;
            int cost = Math.abs(arr[i] - arr[i + j]);
            int cal = helper(arr, k, i + j, dp);
            if(cal != Integer.MAX_VALUE) 
                min = Math.min(min, cost + cal);
        }
        return dp[i] = min;
    }
}
*Optimal : 
  import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] heights = {15, 4, 1, 14, 15};
        int k = 3;
        int[] dp = new int[heights.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        if(heights.length > 1) dp[1] = Math.abs(heights[1] - heights[0]);
        for(int i = 2; i < dp.length; i++) {
           for(int j = i - 1; j >= i - k && j >= 0; j--) {
               dp[i] = Math.min(dp[i],dp[j] + Math.abs(heights[i] - heights[j]));
           }
        }
        System.out.println(dp[heights.length - 1]);
    }
}
*Space Optimization : 
    

Leetcode - 560
  Brute : O(n^3) 
    class Solution {
    public int subarraySum(int[] nums, int target) {
        //Generate All SubArrays
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if(sum == target) {
                    count++;
                }
            }
        }
        return count;
    }
}

Optimal : 
  

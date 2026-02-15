Leetcode - 704
  Brute : O(n)
    class Solution {
    public int search(int[] nums, int target) {
        //Liner Search
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

Optimal : O(logn)
  class Solution {
    public int search(int[] nums, int target) {
        //Binary Search
        int s = 0;
        int e = nums.length - 1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(nums[m] == target) {
                return m;
            }else if(nums[m] > target) {
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return -1;
    }
}

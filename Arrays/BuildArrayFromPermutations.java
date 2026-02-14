Leetcode - 1920
  Brute : 
    class Solution {
    public int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = nums[nums[i]];
        }
        return arr;
    }
}
    Optimal : 
      class Solution {
    public int[] buildArray(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] /= 1000;
        }
        return nums;
    }
}
      

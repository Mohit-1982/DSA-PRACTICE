Leetcode - 2149
  Brute : O(n) and O(n) Space
    class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] neg = new int[nums.length / 2];
        int[] pos = new int[nums.length / 2];
        int j = 0;
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                neg[j++] = nums[i];
            }else {
                pos[k++] = nums[i];
            }
        }
        j = 0;
        k = 0;
        for(int i = 0; i < nums.length; i += 2) {
            nums[i] = pos[j++];
            nums[i + 1] = neg[k++];
        }
        return nums;
    }
}

Optimal : O(n) and O(n) just slight improvement 
  class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int neg = 1;
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                arr[neg] = nums[i];
                neg += 2;
            }else {
                arr[pos] = nums[i];
                pos += 2;
            }
        }
        return arr;
    }
}

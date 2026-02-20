Leetcode - 410
  //Think of it like Ship Capacity Problem
class Solution {
    public int splitArray(int[] nums, int k) {
        int max = -1;
        int sum = 0;
        for(int ele : nums) {
            max = Math.max(ele, max);
            sum += ele;
        }
        int s = max;
        int e = sum;
        int minSum = Integer.MAX_VALUE;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(isValid(nums, k, m)) {
                minSum = Math.min(minSum, m);
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return minSum;
    }
    public boolean isValid(int[] arr, int k, int maxSumAssign) {
        int subAssign = 1;
        int subSum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(subSum + arr[i] > maxSumAssign) {
                subAssign++;
                subSum = arr[i];
                if(subAssign > k) return false;
            }else {
                subSum += arr[i];
            }
        }
        return true;
    }
}

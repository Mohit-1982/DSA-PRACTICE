Leetcode - 53
  Not Optimal And Contains Bugs :
    class Solution {
    public int maxSubArray(int[] arr) {
        int[] kadanes = new int[arr.length];
        if(arr[0] < 0) {
            kadanes[0] = 0;
        }else {
            kadanes[0] = arr[0];
        }
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int sum = kadanes[i - 1] + arr[i];
            if(sum > max) max = sum;
            if(sum < 0) {
                kadanes[i] = 0;
            }else {
                kadanes[i] = sum;
            }
        }
        return max;
    }
}

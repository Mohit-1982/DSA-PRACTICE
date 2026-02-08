Leetcode - 189
  class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(n == 0) return;
        rotate(0,n - k - 1,nums);
        rotate(n - k, n - 1,nums);
        rotate(0, n - 1,nums);
    }
    public void rotate(int i, int j, int[] arr) {
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

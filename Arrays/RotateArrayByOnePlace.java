GFG
  Brute :
  class Solution {
    public void rotate(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n];
        nums[0] = arr[n - 1];
        for(int i = 1; i < n; i++) {
            nums[i] = arr[i - 1];
        }
        for(int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
    }
}

Optimal :
  //In - Place
class Solution {
    public void rotate(int[] arr) {
        int n = arr.length;
        int store = arr[n - 1];
        for(int i = n - 1; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = store;
    }
}

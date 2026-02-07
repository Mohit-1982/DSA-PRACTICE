GFG
  class Solution {
    public static int largest(int[] arr) {
        int max = -1;
        for(int i = 0;i < arr.length;i++) {
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}

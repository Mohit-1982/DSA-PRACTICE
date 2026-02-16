GFG
  class Solution {
    public int findMin(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(arr[m] > arr[e]) {
                //Left Half Sorted
                ans = Math.min(ans, arr[s]);
                s = m + 1; //Eliminate the Sorted Half
            }else {
                //Right Half Sorted
                ans = Math.min(ans, arr[m]);
                e = m - 1;//Eliminate the Sorted Half
            }
        }
        return ans;
    }
}

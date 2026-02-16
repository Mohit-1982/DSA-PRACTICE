GFG
  class Solution {
    public int findKRotation(int arr[]) {
        //Find The Index of Minimum element
        int s = 0;
        int e = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int ansIdx = -1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(arr[m] > arr[e]) {
                if(arr[m] < ans) {
                    ans = arr[s];
                    ansIdx = s;
                }
                s = m + 1;
            }else {
                if(arr[m] < ans) {
                    ans = arr[m];
                    ansIdx = m;
                }
                e = m - 1;
            }
        }
        return ansIdx;
    }
}

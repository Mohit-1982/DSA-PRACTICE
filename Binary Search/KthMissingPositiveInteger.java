GFG
  Brute : TC O(Max Element in Array)
    class Solution {
    public int kthMissing(int[] arr, int k) {
        int max = 0;
        for(int ele : arr) {
            max = Math.max(ele, max);
        }
        int l = 0;
        int missing = 0;
        for(int i = 1; i <= max; i++) {
            if(l < arr.length && arr[l] == i) {
                l++;
            }else{
                missing++;
            }
            if(missing == k) {
                return i;
            }
        }
        if(missing == 0) return arr[arr.length - 1] + k;
        else return arr[arr.length - 1] + k - missing;
    }
}

Optimal : TC O(logn)
  class Solution {
    public int kthMissing(int[] arr, int k) {
        int s = 0;
        int e = arr.length - 1;
        int missing = 0;
        while(s <= e) {
            int m = s + (e - s) / 2;
            missing = arr[m] - m - 1;
            if(missing < k) {
                s = m + 1;
            }else {
                e = m - 1;
            }
        }
        return s + k;
    }
}
  

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
  

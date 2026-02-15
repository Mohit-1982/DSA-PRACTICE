GFG
  Brute : O(n)
    class Solution {
    public int searchInsertK(int arr[], int k) {
        int i;
        for(i = 0; i < arr.length; i++) {
            if(arr[i] >= k) {
                return i;
            }
        }
        return i;
    }
};

Optimal : O(logn)
    class Solution {
    public int searchInsertK(int arr[], int k) {
        int s = 0;
        int e = arr.length - 1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(arr[m] < k) {
                s = m + 1;
            }else {
                e = m - 1;
            }
        }
        return s;
    }
};

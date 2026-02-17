GFG
  class Solution {
    int smallestDivisor(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        int s = 1;
        int e = max;
        int minDivisor = Integer.MAX_VALUE;
        while(s <= e) {
            int m = s + (e - s) / 2;
            int store = getDivisor(arr, k, m);
            if(store <= k) {
                minDivisor = m;
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return minDivisor;
    }
    int getDivisor(int[] arr, int k, int m) {
        int quotient = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % m == 0) {
                quotient += arr[i] / m;
            }else {
                quotient += (arr[i] / m) + 1;
            }
        }
        return quotient;
    }
}

GFG
  class Solution {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        int sum = 0;
        int max = -1;
        for(int ele : arr) {
            sum += ele;
            max = Math.max(max, ele);
        }
        int s = max;
        int e = sum;
        int leastCapacity = Integer.MAX_VALUE;
        while(s <= e) {
            int m = s + (e - s) / 2;
            int day = getDays(arr, d, m);
            if(day <= d) {
                //Valid One's
                leastCapacity = Math.min(leastCapacity, m);
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return leastCapacity;
    }
    static int getDays(int[] arr, int d, int m) {
        int days = 1;
        int capacity = 0;
        for(int i = 0; i < arr.length; i++) {
            if(capacity + arr[i] > m) {
                days++;
                capacity = arr[i];
            }else {
                capacity += arr[i];
            }
        }
        return days;
    }
};

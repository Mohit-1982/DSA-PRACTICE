GFG
  Think of this like ship capacity problem
  class Solution {
    public int minTime(int[] arr, int k) {
        int max = -1;
        int sum = 0;
        for(int ele : arr) {
            max = Math.max(ele, max);
            sum += ele;
        }
        int s = max;
        int e = sum;
        int minTime = Integer.MAX_VALUE;
        while(s <= e) {
            int capacity = s + (e - s) / 2;
            int timeStore = getTime(arr, capacity, k);
            if(timeStore != -1) {
                minTime = Math.min(timeStore, minTime);
                e = capacity - 1;
            }else {
                s = capacity + 1;
            }
        }
        return minTime;
    }
    //Better to create a boolean function
    public int getTime(int[] arr, int cap, int k) {
        int maxTime = -1;
        int painter = 1;
        int painterCap = 0;
        for(int i = 0; i < arr.length; i++) {
            if(painterCap + arr[i] > cap) {
                painter++;
                maxTime = Math.max(maxTime, painterCap);
                painterCap = arr[i];
                if(painter > k) {
                    return -1;
            }
            }else {
                painterCap += arr[i];
            }
        }
        return cap;
    }
}

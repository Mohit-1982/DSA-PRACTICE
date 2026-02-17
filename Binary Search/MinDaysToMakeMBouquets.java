GFG
  class Solution {
    public int minDaysBloom(int[] arr, int k, int booke) {
        if((long)k * booke > arr.length) return -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int s = 1;
        int e = max;
        int days = Integer.MAX_VALUE;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(isValid(arr, booke, k, m)) {
                days = Math.min(days, m);
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        if(days == Integer.MAX_VALUE) {
            return -1;
        }
        return days;
    }
    public boolean isValid(int[] arr, int booke, int k, int m) {
        int bookeCreated = 0;
        int flowerBloom = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= m) {
                flowerBloom++;
            }else {
                flowerBloom = 0;
            }
            if(flowerBloom == k) {
                bookeCreated++;
                flowerBloom = 0;
            }
        }
        return (bookeCreated >= booke);
    }
}

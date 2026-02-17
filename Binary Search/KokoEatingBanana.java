GFG
class Solution {
    public int kokoEat(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int s = 1;
        int e = max;
        int minHour = Integer.MAX_VALUE;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(isValid(arr, m, k)) {
                minHour = Math.min(minHour, m);
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return minHour;
    }
    public boolean isValid(int[] arr, int m, int k) {
        int countHours = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= m) {
                countHours++;
            }else {
                if(arr[i] % m == 0) {
                    countHours += (arr[i] / m);
                }else {
                    countHours += (arr[i] / m) + 1;
                }
            }
        }
        return (countHours <= k);
    }
}

GFG
  class Solution {
    int countFreq(int[] arr, int target) {
        int first = -1;
        int s = 0;
        int e = arr.length - 1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(arr[m] < target) {
                s = m + 1;
            }else if(arr[m] > target) {
                e = m - 1;
            }else {
                first = m;
                e = m - 1;
            }
        }
        int last = -1;
        s = 0;
        e = arr.length - 1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(arr[m] < target) {
                s = m + 1;
            }else if(arr[m] > target) {
                e = m - 1;
            }else {
                last = m;
                s = m + 1;
            }
        }
        if(last == -1 && first == -1) return 0;
        else return last - first + 1;
    }
}

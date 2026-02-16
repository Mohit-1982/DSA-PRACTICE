GFG
  class Solution {
    int search(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(arr[m] == target) {
                return m;
            }else if(arr[m] >= arr[s]) {
                //Left Sorted
                if(arr[m] >= target && arr[s] <= target) {
                    e = m - 1;
                }else {
                    s = m + 1;
                }
            }else {
                //Right Sorted
                if(arr[m] <= target && arr[e] >= target) {
                    s = m + 1;
                }else {
                    e = m - 1;
                }
            }
        }
        return -1;
    }
}

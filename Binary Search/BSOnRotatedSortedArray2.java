GFG
  class Solution {
    public boolean search(int[] arr, int key) {
        int s = 0;
        int e = arr.length - 1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(arr[m] == key) {
                return true;
            }else if(arr[s] == arr[m] && arr[e] == arr[m]) {
                s++;
                e--;
            }else if(arr[m] <= arr[e]) {
                //Right Sorted
                if(arr[m] <= key && arr[e] >= key) {
                    s = m + 1;
                }else {
                    e = m - 1;
                }
            }else {
                //Left Sorted
                if(arr[s] <= key && arr[m] >= key) {
                    e = m - 1;
                }else {
                    s = m + 1;
                }
            }
        }
        return false;
    }
}

GFG
  class Solution {
    int single(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }
        //First Element
        if(arr[0] != arr[1]) {
            return arr[0];
        }
        int s = 1;
        int e = arr.length - 2;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(arr[m] != arr[m + 1] && arr[m] != arr[m - 1]) {
                return arr[m];
            }
            else if((m % 2 == 0 && arr[m] == arr[m + 1]) || (m % 2 == 1 && arr[m] == arr[m - 1])) {
                s = m + 1;
            }else {
                e = m - 1;
            }
        }
        //Last Element
        if(arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        return -1;
    }
}

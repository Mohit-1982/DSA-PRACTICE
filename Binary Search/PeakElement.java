GFG
  class Solution {
    public int peakElement(int[] arr) {
        if(arr.length == 1) {
            return 0;
        }
        //First element Check
        if(arr[0] > arr[1]) {
            return 0;
        }
        int s = 1;
        int e = arr.length - 2;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(arr[m] > arr[m + 1] && arr[m] > arr[m - 1]) {
                return m;
            }else if(arr[m] > arr[m + 1] && arr[m] < arr[m - 1]) {
                //aage wala chota h vo peak nhi ho skta but piche wala peak possible ha
                e = m - 1;
            }else {
                //piche wala chota h vo peak nhi ho skta tho hum agge wale ko check krenge
                s = m + 1;
            }
        }
        //Last element Check
        if(arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr.length - 1;
        }
        return -1;
    }
}

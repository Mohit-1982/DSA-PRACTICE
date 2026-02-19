GFG
  class Solution {
    public int findPages(int[] arr, int k) {
        if(k > arr.length) return -1;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int ele : arr) {
            max = Math.max(ele, max);
            sum += ele;
        }
        int s = max;
        int e = sum;
        int minPages = Integer.MAX_VALUE;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(isValid(arr, m, k)) {
                minPages = Math.min(minPages, m);
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return minPages;
    }
    public boolean isValid(int[] arr, int m, int k) {
        int maxPages = Integer.MIN_VALUE;
        int pages = 0;
        int studentAllocated = 1;
        for(int i = 0; i < arr.length; i++) {
            if(pages + arr[i] > m) {
                studentAllocated++;
                pages = arr[i];
                if(studentAllocated > k) {
                    return false;
                }
            }else {
                pages += arr[i];
            }
        }
        return true;
    }
}

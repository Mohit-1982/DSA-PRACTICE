GFG
  class Solution {
    public int getSecondLargest(int[] arr) {
        int n = arr.length;
        int largest = -1;
        int secLargest = -1;
        for(int i = 0; i < n; i++) {
            if(arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            }else if(arr[i] < largest && arr[i] > secLargest) {
                secLargest = arr[i];
            }
        }
        return secLargest;
    }
}

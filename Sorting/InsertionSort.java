TC : O(n^2)
  class Solution {
    public void insertionSort(int arr[]) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int k = i;
            while(k > 0 && arr[k] < arr[k - 1]) {
                int temp = arr[k];
                arr[k] = arr[k - 1];
                arr[k - 1] = temp;
                k--;
            }
        }
    }
}
Recursively
  class Solution {
    public void insertionSort(int arr[]) {
        insertionRecurse(arr, 1);
    }
    public void insertionRecurse(int[] arr, int k) {
        if(k == arr.length) return;
        int i = k;
        while(i > 0 && arr[i] < arr[i - 1]) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
            i--;
        }
        insertionRecurse(arr, k + 1);
    }
}

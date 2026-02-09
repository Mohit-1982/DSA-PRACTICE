GFG
  TC : O(nlogn)
    SC : O(n)
  class Solution {
    void mergeSort(int arr[], int l, int r) {
        int n = arr.length;
        if(n <= 1) return;
        //create two arrays and paste all the elements of arr into it
        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];
        int k = 0;
        for(int i = 0; i < a.length; i++) {
            a[i] = arr[k++];
        }
        for(int i = 0; i < b.length; i++) {
            b[i] = arr[k++]; 
        }
        mergeSort(a,l,r);
        mergeSort(b,l,r);
        mergeHelper(a,b,arr);
    }
    void mergeHelper(int[] a,int[] b,int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                arr[k++] = a[i++];
            }else {
                arr[k++] = b[j++];
            }
        }
        while(i < a.length) {
            arr[k++] = a[i++];
        }
        while(j < b.length) {
            arr[k++] = b[j++];
        }
    }
}

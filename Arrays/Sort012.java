GFG
  Brute : O(nlogn) Sorting
    class Solution {
    public void sort012(int[] arr) {
        sort(arr);
    }
    public void sort(int[] arr) {
        int n = arr.length;
        if(n <= 1) {
            return;
        }
        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];
        int k = 0;
        for(int i = 0; i < a.length; i++) {
            a[i] = arr[k++];
        }
        for(int i = 0; i < b.length; i++) {
            b[i] = arr[k++];
        }
        sort(a);
        sort(b);
        merge(a,b,arr);
    }
    public void merge(int[] a, int[] b, int[] arr) {
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

Better : O(n) Count Number of 0 1 2 in Array and then modify the array
  class Solution {
    public void sort012(int[] arr) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                count0++;
            }else if(arr[i] == 1) {
                count1++;
            }else {
                count2++;
            }
        }
        int k = 0;
        for(int i = 0; i < count0; i++) {
            arr[k++] = 0;
        }
        for(int i = 0; i < count1; i++) {
            arr[k++] = 1;
        }
        for(int i = 0; i < count2; i++) {
            arr[k++] = 2;
        }
    }
}

Optimal : O(n) Dutch National Flag Algorithm
  class Solution {
    public void sort012(int[] arr) {
        //Dutch National Flag Algorithm
        int low = 0;
        int high = arr.length - 1;
        int mid = low;
        while(mid <= high) {
            if(arr[mid] == 0) {
                swap(arr,low,mid);
                low++;
                mid++;
            }else if(arr[mid] == 1) {
                mid++;
            }else {
                //arr[mid] == 2
                swap(arr,mid,high);
                high--;
            }
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
  
  

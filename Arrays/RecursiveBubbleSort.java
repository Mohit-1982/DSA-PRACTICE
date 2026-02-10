GFG
  class Solution {
    public void bubbleSort(int[] arr) {
        //Recursively
        int idx = 0;
        int n = arr.length;
        for(int i = 0; i < arr.length - 1; i++) {
           recursion(idx,arr,n - i - 1); 
        }
    }
    public void recursion(int idx,int[] arr,int end) {
        if(idx >= end) {
            return;
        }
        if(arr[idx] > arr[idx + 1]) {
            int temp = arr[idx];
            arr[idx] = arr[idx + 1];
            arr[idx + 1] = temp;
        }
        recursion(idx + 1,arr,end);
    }
}


Reverse Bubble sort :
  class Solution {
    public void bubbleSort(int[] arr) {
        //Recursively
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
           recursion(idx + i,arr,i); 
        }
    }
    public void recursion(int idx,int[] arr,int i) {
        if(idx >= arr.length - 1) {
            return;
        }
        recursion(idx + 1,arr,i);
        if(arr[idx] > arr[idx + 1]) {
            int temp = arr[idx];
            arr[idx] = arr[idx + 1];
            arr[idx + 1] = temp;
        }
    }
}

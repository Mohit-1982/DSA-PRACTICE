class Solution {
    void mergeSort(int arr[], int s, int e) {
        //IN PLACE MERGE SORT
        if(e - s == 1) {
            return;
        }
            int m = s + (e - s) / 2;
            mergeSort(arr,s,m);
            mergeSort(arr,m,e);
            mergeHelper(arr,s,m,e);
    }
    void mergeHelper(int[] arr,int s,int m,int e) {
        int[] mix = new int[e - s];//create a new array which will store our elements
        int i = s;
        int j = m;
        int k = 0;
        while(i < m && j < e) {
            if(arr[i] < arr[j]) {
                mix[k++] = arr[i++];
            }else {
                mix[k++] = arr[j++];
            }
        }
        while(i < m) {
            mix[k++] = arr[i++];
        }
        while(j < e) {
            mix[k++] = arr[j++];
        }
        
        //now add all the values in our original array
        for(int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }
}

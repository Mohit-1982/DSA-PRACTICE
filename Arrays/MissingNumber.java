GFG
  Brute :
  class Solution {
    int missingNum(int arr[]) {
        //Little Bit Brute 
        //Cyclic sort
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int correctIdx = arr[i] - 1;
            if(arr[i] >= 1 && arr[i] <= n && arr[i] != arr[correctIdx]) {
                //Swap
                int temp = arr[correctIdx];
                arr[correctIdx] = arr[i];
                arr[i] = temp;
            }else {
                i++;
            }
        }
        //check which number is not present
        for(i = 0; i < n; i++) {
            if(i != arr[i] - 1) {
                return i + 1;
            }
        }
        return i + 1;
    }
}

Optimal :
  class Solution {
    int missingNum(int arr[]) {
        int n = arr.length;
        long sum = (long)(n + 1) * (n + 2) / 2;
        // for(int i = 1; i <= n + 1; i++) {
        //     sum += i;
        // }
        long arrSum = 0;
        for(int i = 0; i < n; i++) {
            arrSum += arr[i];
        }
        return (int)(sum - arrSum);
    }
}

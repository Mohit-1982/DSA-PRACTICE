GFG
Brute : O(n^3)
  class Solution {
    int maxLength(int arr[]) {
        int n = arr.length;
        int len = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += arr[k];
                    if(sum == 0) {
                        len = Math.max(len,k - i + 1);
                    }
                }
            }
        }
        return len;
    }
}

Better : O(n^2)
  class Solution {
    int maxLength(int arr[]) {
        int n = arr.length;
        int len = 0;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                    sum += arr[j];
                if(sum == 0) {
                    len = Math.max(len,j - i + 1);
                }
            }
        }
        return len;
    }
}

Optimal : 
  

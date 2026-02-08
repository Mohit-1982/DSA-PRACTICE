GFG
  class Solution {
    public int maxConsecBits(int[] arr) {
        int n = arr.length;
        //Ones count
        int oneLen = 0;
        int i = 0;
        int j = 0;
        while(j < n) {
            if(arr[j] == 1) {
                oneLen = Math.max(oneLen,j - i + 1);
            }else {
                i = j + 1;
            }
            j++;
        }
        
        //Zero count
        i = 0;
        j = 0;
        int zeroLen = 0;
        while(j < n) {
            if(arr[j] == 0) {
                zeroLen = Math.max(zeroLen,j - i + 1);
            }else {
                i = j + 1;
            }
            j++;
        }
        
        return Math.max(zeroLen,oneLen);
    }
}

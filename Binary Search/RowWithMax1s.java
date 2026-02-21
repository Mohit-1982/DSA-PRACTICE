GFG
  Brute :
    class Solution {
    public int rowWithMax1s(int arr[][]) {
        int[] nums = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            int rowCount = 0;
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) {
                    rowCount++;
                }
            }
            nums[i] = rowCount;
        }
        int maxRow = -1;
        int max = -1;
        for(int i = 0; i < nums.length; i++) {
            if(max < nums[i]) {
                max = nums[i];
                maxRow = i;
            }
        }
        if(max == 0) return -1;
        return maxRow;
    }
}
Better :
  class Solution {
    public int rowWithMax1s(int arr[][]) {
        int prevMax = 0;
        int maxRow = -1;
        for(int i = 0; i < arr.length; i++) {
            int currMax = 0;
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) currMax++;
            }
            if(currMax > prevMax) {
                prevMax = currMax;
                maxRow = i;
            }
        }
        return maxRow;
    }
}

Optimal :
  TC O(n logm)
  class Solution {
    public int rowWithMax1s(int arr[][]) {
        //We can use Lower Bound Upper Bound First Occurance any one
        //of these to solve this question
        int maxRow = -1;
        int prevMax = Integer.MAX_VALUE;
        int currMax;
        for(int i = 0; i < arr.length; i++) {
            currMax = firstOccu(arr[i]);
            if(currMax != -1 && currMax < prevMax) {
                //More the Number of ones smaller the idx
                prevMax = currMax;
                maxRow = i;
            }
        }
        return maxRow;
    }
    public int firstOccu(int[] arr) {
        int s = 0;
        int e = arr.length -1;
        int idx = -1;
        while(s <= e) {
            int m = s +((e - s) >> 1);
            if(arr[m] == 1) {
                idx = m;
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return idx;
    }
}

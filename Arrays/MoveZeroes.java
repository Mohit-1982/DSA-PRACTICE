Leetcode - 283
  Brute : Bubble Sort
    class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}

Better :
  class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int k = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                arr[k++] = nums[i];
            }
        }
        for(int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
    }
}

Optimal :
  class Solution {
    public void moveZeroes(int[] nums) {
        //Step 1 : Find the First Element Index Which Contains Zero
        int j = -1;
        int n = nums.length;
        for(int i = 0;i < n; i++) {
            if(nums[i] == 0) {
                j = i;
                break;
            }
        }

        if(j == -1) return; //if j is still -1 in this there is no element which is zero

        //Step 2 : Move all the zero element to the last and non zero to the front
        for(int i = j + 1; i < n; i++) {
            //we are traversing i over the loop for non zero elements
            if(nums[i] != 0) {
                //Swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}

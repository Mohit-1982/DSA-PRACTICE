Leetcode - 1752
  Brute : 
    class Solution {
    public boolean check(int[] nums) {
        int i;
        int n = nums.length;
        boolean flag = false;
        for(i = 0; i < n - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                flag = true;
                break;
            }
        }
        if(flag) {
            rotate(0,i,nums);
            rotate(i + 1,n - 1,nums);
            for(int j = 0; j < n - 1; j++) {
                if(nums[j] < nums[j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
    public void rotate(int i, int j, int[] arr) {
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

Optimal : check previous element is greater than you or not and at last check is 1st element greater than last or not
  class Solution {
    public boolean check(int[] nums) {
        int i;
        int n = nums.length;
        int count = 0;
        for(i = 1; i < n; i++) {
            if(nums[i - 1] > nums[i]) {
                count++;
            }
        }
        if(nums[n - 1] > nums[0]) {
            count++;
        }
        return count <= 1;
    }
}

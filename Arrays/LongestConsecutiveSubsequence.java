Leetcode - 128
  Brute : Using Sorting and Checking consecutive sequence
    class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxLen = 0;
        int len = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                continue;
            }
            if(nums[i] == nums[i + 1] - 1) {
                len++;
            }
            else {
                maxLen = Math.max(maxLen,len);
                len = 1;
            }
        }
        maxLen = Math.max(maxLen,len);
        return maxLen;
    }
}

Optimal :
  Not Good Readability :
    class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int len = 1;
        int maxLen = 0;
        //Insert all the elements in set
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(int ele : set) {
            if(set.contains(ele - 1)) {
                continue;
            }else {
                while(true) {
                    ele += 1;
                    if(set.contains(ele)) {
                        len++;
                    }else {
                        maxLen = Math.max(maxLen, len);
                        len = 1;
                        break;
                    }
                }
            }
        }
        return maxLen;
    }
}

BEst :
  class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int maxLen = 0;
        //Insert all the elements in set
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(int ele : set) {
            int len = 1;
            if(!set.contains(ele - 1)) {
                while(set.contains(ele + len)) {
                    len++;
                }
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}

Leetcode - 18
  Brute : O(n^4) 
    class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    for(int l = k + 1; l < n; l++) {
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            set.add(list);
                        }
                    }
                }
            }
        }
        for(List<Integer> ele : set) {
            ans.add(ele);
        }
        return ans;
    }
}

Optimal : O(n^3) SC : O(1)
  class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            //Avoid i duplicates
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j++) {
                //Avoid j duplicates
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int m = n - 1;
                while(k < m) {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[m];
                    if(sum > target) {
                        m--;
                    }else if(sum < target) {
                        k++;
                    }else {
                        //found our answer
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[m]);
                        ans.add(list);
                        k++;
                        m--;
                        //Avoid Duplicates
                        while(k < m && nums[k] == nums[k - 1]) k++;
                        while(m > k && nums[m] == nums[m + 1]) m--; 
                    }
                }
            }
        }
        return ans;
    }
}

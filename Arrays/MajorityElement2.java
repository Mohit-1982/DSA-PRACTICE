Leetcode - 229
  Brute : Using HashMap
    class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums) {
            map.put(ele, map.getOrDefault(ele,0) + 1);
        }
        for(int ele : map.keySet()) {
            if(map.get(ele) > nums.length / 3) {
                list.add(ele);
            } 
        }
        return list;
    }
}

Optimal : Boores Moore Voting Algo
  class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int ele1 = 0;
        int ele2 = 0;
        int freq1 = 0;
        int freq2 = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == ele1) {
                freq1++;
            }else if(nums[i] == ele2) {
                freq2++;
            }else if(freq1 == 0) {
                ele1 = nums[i];
                freq1 = 1;
            }else if(freq2 == 0) {
                ele2 = nums[i];
                freq2 = 1;
            }else {
                freq1--;
                freq2--;
            }
        }
        freq1 = 0;
        freq2 = 0;
        for(int ele : nums) {
            if(ele == ele1) freq1++;
            else if(ele == ele2) freq2++;
        }
        if(freq1 > n / 3) list.add(ele1);
        if(freq2 > n / 3) list.add(ele2);
        return list;
    }
}

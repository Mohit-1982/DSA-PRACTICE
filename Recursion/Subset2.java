Leetcode - 90
  Brute :
    class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        genSubset(nums, list, set, 0);
        for(List<Integer> ele : set) {
            res.add(ele);
        }
        return res;
    }
    public void genSubset(int[] arr, List<Integer> list, HashSet<List<Integer>> set, int idx) {
        if(idx >= arr.length) {
            set.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[idx]);
        genSubset(arr, list, set, idx + 1);
        list.remove(list.size() - 1);
        genSubset(arr, list, set, idx + 1);
    }
}

Optimal : 
  class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        genSubset(nums, res, list, 0);
        res.add(new ArrayList<>());
        return res;
    }
    public void genSubset(int[] arr, List<List<Integer>> res, List<Integer> list, int idx) {
        if(idx >= arr.length) return;

        for(int i = idx; i < arr.length; i++) {
            if(i > idx && arr[i] == arr[i - 1]) continue; //Avoid duplicates
            list.add(arr[i]);
            res.add(new ArrayList<>(list));
            genSubset(arr, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

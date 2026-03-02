Leetcode - 40
  Brute : 
    class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        genComb(candidates, target, set, list, 0);
        for(List<Integer> ele : set) {
            res.add(ele);
        }
        return res;
    }
    public void genComb(int[] arr, int target, HashSet<List<Integer>> set, List<Integer> list, int idx) {
        if(idx >= arr.length) {
            if(target == 0) {
                set.add(new ArrayList<>(list));
            }
            return;
        }
        if(target - arr[idx] < 0) {
            genComb(arr, target, set, list, idx + 1);
            return;
        }
        list.add(arr[idx]);
        //pick
        genComb(arr, target - arr[idx], set, list, idx + 1);
        //BackTrack the ans you have added in the list
        list.remove(list.size() - 1);
        //skip
        genComb(arr, target, set, list, idx + 1);
    }
}

Optimal : 
  class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        getCombo(candidates, target, res, list, 0);
        return res;
    }
    public void getCombo(int[] arr, int target, List<List<Integer>> res, List<Integer> list, int idx) {
            if(target == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
        for(int i = idx; i < arr.length; i++) {
            if(i > idx && arr[i] == arr[i - 1]) continue;
            if(arr[i] > target) break;

            list.add(arr[i]);
            getCombo(arr, target - arr[i], res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

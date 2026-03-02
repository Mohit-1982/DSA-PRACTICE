Leetcode - 39
  class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        genComb(candidates, target, res, list, 0);
        return res;
    }
    public void genComb(int[] arr, int trg, List<List<Integer>> res, List<Integer> list, int idx) {
        if(idx >= arr.length) {
            if(trg == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if(trg - arr[idx] < 0) {
            genComb(arr, trg, res, list, idx + 1);
            return;
        }
        list.add(arr[idx]);
        //pick
        genComb(arr, trg - arr[idx], res, list, idx);
        list.remove(list.size() - 1);
        //skip
        genComb(arr, trg, res, list, idx + 1);
    }
}

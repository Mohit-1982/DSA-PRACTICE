Leetcode - 216
  class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        genComb(k, n, res, list, 0, 1);
        return res;
    }
    public void genComb(int k, int n, List<List<Integer>> res, List<Integer> list, int sum, int start) {
        if(list.size() == k) {
            if(sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        } 
        for(int i = start; i <= 9; i++) {
            if(sum + i > n) break;
                list.add(i);
                genComb(k, n, res, list, sum + i, i + 1);
                list.remove(list.size() - 1);
        }
    }
}

GFG
  class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        genSubsets(arr, res, list, 0);
        return res;
    }
    public void genSubsets(int[] arr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int idx) {
        if(idx >= arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        //pick
        list.add(arr[idx]);
        genSubsets(arr, res, list, idx + 1);
        //Now remove the element we have added earlier
        list.remove(list.size() - 1);
        //skip
        genSubsets(arr, res, list, idx + 1);
    }
}

Leetcode - 118 O(n^2) and O(n)
  class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        pascal(numRows,ans);
        return ans;
    }
    public void pascal(int row, List<List<Integer>> ans) {
        if(row == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            ans.add(list);
            return;
        }
        pascal(row - 1, ans);
        List<Integer> addInList = new ArrayList<>();
        int top = 0;
        int topLeft = 0;
        for(int i = 0; i < row; i++) {
            if(i == 0 || i == row - 1) {
                addInList.add(1);
            }else {
                top = ans.get(ans.size() - 1).get(i);
                topLeft = ans.get(ans.size() - 1).get(i - 1);
                addInList.add(top + topLeft);
            }
        }
        ans.add(addInList);
    }
}

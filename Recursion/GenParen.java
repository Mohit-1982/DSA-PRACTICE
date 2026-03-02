Leetcode - 22
  class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        makeParen(n, res, 0, 0, "");
        return res;
    }
    public void makeParen(int n, List<String> res, int l, int r, String p) {
        if(r == n) {
            res.add(p);
            return;
        }
        if(l < n) makeParen(n, res, l + 1, r, p + '(');
        if(r < l) makeParen(n, res, l, r + 1, p + ')');
    }
}

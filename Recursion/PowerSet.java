GFG
  class Solution {
    public List<String> AllPossibleStrings(String s) {
         List<String> res = new ArrayList<>();
         powerSet(s, res, "");
         Collections.sort(res);
         return res;
    }
    public void powerSet(String s, List<String> res, String p) {
        //Base Case
        if(s.isEmpty()) {
            res.add(p);
            return;
        }
        //skip
        powerSet(s.substring(1), res, p);
        //pick
        powerSet(s.substring(1), res, p + s.charAt(0));
    }
}

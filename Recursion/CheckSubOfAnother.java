GFG
  class Solution {
    public boolean isSubSeq(String s1, String s2) {
        int i = 0;
        int j = 0;
        while(j < s2.length()) {
            if(i == s1.length()) return true;
            if(s2.charAt(j) == s1.charAt(i)) i++;
            j++;
        }
        if(i == s1.length()) return true;
        return false;
    }
};

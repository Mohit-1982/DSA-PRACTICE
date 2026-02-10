Leetcode - 58
  class Solution {
    public int lengthOfLastWord(String s) {
        int maxLen = 0;
        int i = s.length() - 1;
        //Check is there any space at end or not
        while(i >= 0) {
            if(s.charAt(i) == ' ') {
                i--;
            }else {
                break;
            }
        }
        //Find Length of Last Word
        while(i >= 0) {
            if(s.charAt(i) == ' ') {
                break;
            }
            maxLen++;
            i--;
        }
        return maxLen;
    }
}

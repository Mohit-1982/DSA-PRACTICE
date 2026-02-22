Leetcode - 14
  Brute :
    class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = 0;
        if(strs.length == 0) return "";
        while(true) {
            if(len < strs[0].length()) {
                boolean allWell = true;
                char ch = strs[0].charAt(len);
                for(int i = 0; i < strs.length; i++) {
                    if(len < strs[i].length() && strs[i].charAt(len) == ch) {
                        continue;
                    }else {
                        allWell = false;
                        break;
                    }
                }
                if(allWell) {
                    len++;
                }else {
                    break;
                }
            }else {
                break;
            }
        }
        return strs[0].substring(0, len);
    }
}

Better : 
  class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length - 1];
        int i = 0;
        while(true) {
            if(i < start.length() && start.charAt(i) == end.charAt(i)) {
                i++;
            }else {
                break;
            }
        }
        return start.substring(0, i);
    }
}

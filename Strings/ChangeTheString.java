GFG
  class Solution {
    String modify(String s) {
        //if we need O(1) space then we need to create a character array
        StringBuilder sb = new StringBuilder();
        if(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    char str = (char) (s.charAt(i) - 32);
                    sb.append(str);
                }else {
                    sb.append(s.charAt(i));
                }
            }
        }else {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    char str = (char) (s.charAt(i) + 32);
                    sb.append((str));
                }else {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}

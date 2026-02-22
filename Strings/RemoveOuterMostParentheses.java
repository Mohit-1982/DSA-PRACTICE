Leetcode - 1021
  Brute :
  class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                if(!st.isEmpty()) {
                    res += ch;
                }
                st.push(ch);
            }else {
                st.pop();
                if(!st.isEmpty()) {
                    res += ch;
                }
            }
        }
        return res;
    }
}

Optimal :
  class Solution {
    public String removeOuterParentheses(String s) {
        int counter = 0;
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                if(counter > 0) {
                    res += ch;
                }
                counter++;
            }else { //if ch == ')'
                counter--;
                if(counter > 0) {
                    res += ch;
                }
            }
        }
        return res;
    }
}

Leetcode - 151
  Brute :
    class Solution {
    public String reverseWords(String s) {
        int i = 0;
        if(s.charAt(0) == ' ') i = giveIdx(s, i);
        int j = i;
        Stack<String> st = new Stack<>();
        for(int k = i; k < s.length(); k++) {
            if(j < s.length() && s.charAt(j) != ' ') j++;
            else {
                st.push(s.substring(i, j));
                i = giveIdx(s, j + 1);
                j = i;
                if(j >= s.length()) break;
            }
        }
        if(i < s.length()) st.push(s.substring(i, j));
        String res = "";
        while(!st.isEmpty()) {
            String pop = st.pop();
            res += pop;
            if(!st.isEmpty()) res += " ";
        }
        return res;
    }
    public int giveIdx(String s, int idx) {
        int i;
        for(i = idx;i < s.length(); i++) {
            if(s.charAt(i) == ' ') continue;
            else break;
        }
        return i;
    }
}

Brute Readiblity better :
  class Solution {
    public String reverseWords(String s) {
        int i = 0;
        int j = 0;
        while(j < s.length()) {
            if(s.charAt(j) == ' ') j++;
            else break;
        }
        i = j;
        Stack<String> st = new Stack<>();
        while(j < s.length()) {
            if(s.charAt(j) != ' ') j++;
            else {
                st.push(s.substring(i, j));
                j++;
                while(j < s.length()) {
                    if(s.charAt(j) == ' ') j++;
                    else break;
                }
                i = j;
                if(j >= s.length()) break;
            }
        }
        if(i < s.length()) st.push(s.substring(i, j));
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
            if(!st.isEmpty()) sb.append(" ");
        }
        return sb.toString();
    }
}

Better :
  class Solution {
    public String reverseWords(String s) {
        int i = s.length() - 1;
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(j >= 0 && s.charAt(j) == ' ') j--;
        i = j;
        boolean first = true;
        while(j >= 0) {
            if(j >= 0 && s.charAt(j) != ' ') j--;
            else {
                if(!first) sb.append(" ");
                first = false;
                sb.append(s.substring(j + 1, i + 1));
                while(j >= 0 && s.charAt(j) == ' ') j--;
                i = j;
            }
        }
        if(i >= 0) {
            if(!first) sb.append(" ");
            sb.append(s.substring(j + 1, i + 1));
        }
        return sb.toString();
    }
}
  

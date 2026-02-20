Leetcode - 389
  class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0) return t.charAt(0);
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                int freq = map.get(ch);
                map.put(ch, freq + 1);
            }else {
                map.put(ch, 1);
            }
        }
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(map.containsKey(ch)) {
                int freq = map.get(ch);
                map.put(ch, freq - 1);
                if(map.get(ch) == 0) {
                    map.remove(ch);
                }
            }else {
                return ch;
            }
        }
        return 'm';
    }
}

Optimal : Using XOR operator property
  class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for(int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
        }
        for(int i = 0; i < t.length(); i++) {
            res ^= t.charAt(i);
        }
        return res; 
    }
}

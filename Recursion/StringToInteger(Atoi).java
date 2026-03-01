Leetcode - 8
  Iteratively : 
    class Solution {
    public int myAtoi(String s) {
        boolean firstDigitEncou = false;
        int sign = 1;
        int j = 0;
        //Handle leading spaces
        while(j < s.length() && s.charAt(j) == ' ') j++;
        //Handle sign
        if(j < s.length() && (s.charAt(j) == '+' || s.charAt(j) == '-')) {
            sign = (s.charAt(j) == '-') ? -1 : 1;
            j++;
        }
        //conversion
        long res = 0;
        for(int i = j; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                if(!firstDigitEncou) firstDigitEncou = true;
                res = res * 10 + (ch - '0');
                //overflow check
                if(res >= Integer.MAX_VALUE && sign == 1) return Integer.MAX_VALUE;
                if(res > Integer.MAX_VALUE && sign == -1) return Integer.MIN_VALUE;
            }else {
                if(!firstDigitEncou) return 0;
                else break;
            }
        }
        //return ans with sign multiplication
        return (int) (res * sign);
    }
}

Recursively : 
  class Solution {
    public int myAtoi(String s) {
        //Handle leading spaces
        int i = spaces(s, 0);
        if(i == -1) return 0;
        //Handle sign
        int sign = 1;
        if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        //conversion
        int res = conversion(s, i, false, sign, 0);
        //return ans with sign multiplication
        return res;
    }
    public int conversion(String s, int i, boolean fstDigEnc, int sign, long res) {
        if(i >= s.length()) return (int) (sign * res);
        char ch = s.charAt(i);
        if(ch >= '0' && ch <= '9') {
            if(!fstDigEnc) fstDigEnc = true;
            res = res * 10 + (ch - '0');
            if(res >= Integer.MAX_VALUE && sign == 1) return Integer.MAX_VALUE;
            if(res > Integer.MAX_VALUE && sign == -1) return Integer.MIN_VALUE;
            return conversion(s, i + 1, fstDigEnc, sign, res);
        }else {
            if(!fstDigEnc) return 0;
            else return (int) (sign * res);
        }
    }
    public int spaces(String s, int i) {
        if(i >= s.length()) return -1;
        if(s.charAt(i) != ' ') return i;
        return spaces(s, i + 1);
    }
}

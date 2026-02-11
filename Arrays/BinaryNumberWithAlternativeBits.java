Leetcode - 693
  Brute : 
    class Solution {
    public boolean hasAlternatingBits(int n) {
        int count = 0;
        int count2 = 0;
        while(n != 0) {
            if(count == 1 && ((n & 1) == 1)) {
                return false;
            }
            else if((n & 1) == 1) {
                count++;
            }else {
                count = 0;
            }
            if(count2 == 1 && ((n & 1) == 0)) {
                return false;
            }
            else if((n & 1) == 0) {
                count2++;
            }else {
                count2 = 0;
            }
            n = n >> 1;
        }
        return true;
    }
}

Optimal :
  class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = -1;
        while(n != 0) {
            int curr = n & 1;
            if(prev == curr) {
                return false;
            }
            prev = curr;
            n = n >> 1;
        }
        return true;
    }
}

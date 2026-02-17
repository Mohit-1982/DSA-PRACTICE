GFG
  class Solution {
    int floorSqrt(int n) {
        int s = 1;
        int e = n;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(m * m == n) {
                return m;
            }else if(m * m > n) {
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return e;
    }
}

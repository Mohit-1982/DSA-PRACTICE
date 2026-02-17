GFG
  This can Cause Overflow error
    TC : O(logn * log(lastValue))
  class Solution {
    public int nthRoot(int n, int lastValue) {
        int s = 0;
        int e = lastValue;
        while(s <= e) {
            int m = s + (e - s) / 2;
            int pow = (int)Math.pow(m, n);
            if(pow == lastValue) {
                return m;
            }else if(pow > lastValue) {
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return -1;
    }
}

Optimal :
  TC : O(n log(lastValue))
      class Solution {
    public int nthRoot(int n, int lastValue) {
        int s = 0;
        int e = lastValue;
        while(s <= e) {
            int m = s + (e - s) / 2;
            int pow = 1;
            for(int i = 0; i < n; i++) {
                pow *= m;
                if(pow > lastValue) break;
            }
            if(pow == lastValue) {
                return m;
            }else if(pow > lastValue) {
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return -1;
    }
}

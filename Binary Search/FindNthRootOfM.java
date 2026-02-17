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

Best :
class Solution {
    public int nthRoot(int n, int m) {
        //O(n * logm)
        int s = 0;
        int e = m;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            int pow = power(mid,n,m);
            if(pow == 1) {
                return mid;
            }else if(pow == 2) {
                e = mid - 1;
            }else {
                s = mid + 1;
            }
        }
        return -1;
    }
    //2 means greater then m search on left
    //1 means we got the answer return 
    //0 means its less then m search on right
    //this function will help in overflow error 
    public int power(int mid,int n,int m) {
        long ans = 1;
        for(int i = 1;i<=n;i++) {
            ans *= mid;
            if(ans > m) return 2;
        }
        if(ans == m) return 1;
        return 0;
    }
}

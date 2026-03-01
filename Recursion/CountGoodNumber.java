Leetcode - 1922
  class Solution {
    public int countGoodNumbers(long n) {
        return (int)((findPow(5, (n + 1) / 2) * findPow(4, n / 2)) % 1000000007);
    }
    public long findPow(long a, long b) {
        if(b == 0) return 1;
        if(b == 1) return a;
        long halfPow = findPow(a, b / 2);
        if(b % 2 == 0) return (halfPow * halfPow) % 1000000007;
        else return (halfPow * halfPow * a) % 1000000007;
    }
}

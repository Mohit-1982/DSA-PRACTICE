GFG
  class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        boolean[] sieve = new boolean[leaves + 1];
        for(int i = 0; i < frogs.length; i++) {
            if(frogs[i] == 1) return 0;
            for(int j = frogs[i]; j <= leaves; j += frogs[i]) {
                sieve[j] = true;
            }
        }
        int count = 0;
        for(int i = 1; i <= leaves; i++) {
            if(!sieve[i]) count++;
        }
        return count;
    }
}

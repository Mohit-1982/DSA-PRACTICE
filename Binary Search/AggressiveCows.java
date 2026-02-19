GFG
  class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int s = 1;
        int e = stalls[stalls.length - 1] - stalls[0];
        int maxDist = Integer.MIN_VALUE;
        while(s <= e) {
            int dist = s + (e - s) / 2;
            if(minBWCows(stalls, k, dist)) {
                maxDist = Math.max(maxDist, dist);
                s = dist + 1;
            }else {
                e = dist - 1;
            }
        }
        return maxDist;
    }
    public boolean minBWCows(int[] arr, int k, int dist) {
        int prevCow = arr[0];
        int cowPlaced = 1;
        for(int i = 1; i < arr.length; i++) {
            int diff = arr[i] - prevCow;
            if(diff >= dist) {
                prevCow = arr[i];
                cowPlaced++;
            }
            if(cowPlaced >= k) {
                return true;
            }
        }
        return false;
    }
}

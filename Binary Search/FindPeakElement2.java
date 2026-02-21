Leetcode - 1901
  class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int s = 0;
        int e = mat[0].length - 1;
        while(s <= e) {
            int m = s + ((e - s) >> 1);
            int maxRow = 0;
            for(int i = 0; i < mat.length; i++) {
                if(mat[i][m] > mat[maxRow][m]) {
                    maxRow = i;
                }
            }
            int left = (m - 1 >= 0) ? mat[maxRow][m - 1] : -1;
            int right = (m + 1 < mat[0].length) ? mat[maxRow][m + 1] : -1;
            if(mat[maxRow][m] > left && mat[maxRow][m] > right) return new int[]{maxRow, m};
            else if(mat[maxRow][m] < right) s = m + 1;
            else e = m - 1;
        }
        return new int[]{-1, -1};
    }
}

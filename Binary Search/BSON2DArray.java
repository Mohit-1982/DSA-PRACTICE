Leetcode - 74
  Brute 
    class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                for(int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j] == target) return true;
                }
            }else {
                continue;
            }
        }
        return false;
    }
}
Better : 
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            int s = 0;
            int e = matrix[i].length - 1;
            while(s <= e) {
                int m = s + (e - s) / 2;
                if(matrix[i][m] == target) return true;
                else if(matrix[i][m] > target) e = m - 1;
                else s = m + 1;
            }
        }
        return false;
    }
}

Optimal :
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int s = 0;
        int e = (n * m) - 1;
        while(s <= e) {
            int mid = s + ((e - s) >> 1);
            int row = mid / m;
            int col = mid % m;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) e = mid - 1;
            else s = mid + 1; 
        }
        return false;
    }
}
  

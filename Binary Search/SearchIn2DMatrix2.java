Leetcode - 240
  Brute :
    class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;
        while(row < n && col >= 0) {
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++; 
        }
        return false;
    }
}

Optimal :
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while(row >= 0 && col < matrix[0].length) {
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) row--;
            else col++;
        }
        return false;
    }
}

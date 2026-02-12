Leetcode - 48 
  Transpose + Reverse rows
  Brute : O(n^2) Time and Space
    class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = matrix[n - j - 1][i];
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = arr[i][j];
            }
        }
    }
}

Optimal : 
  class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //Transpose
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Reverse Every Row
        for(int i = 0; i < n; i++) {
            int j = n - 1;
            int k = 0;
            while(k < j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                k++;
                j--;
            }
        }
    }
}

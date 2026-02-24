Leetcode - 931
  Brute : 
    class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[] arr = new int[1];
        arr[0] = Integer.MAX_VALUE;
        for(int col = 0; col < matrix[0].length; col++) {
            minPath(matrix, 0, col, arr, 0);
        }
        return arr[0];
    }
    public void minPath(int[][] arr, int row, int col, int[] store, int sum) {
        if(col >= arr[0].length || col < 0) return;
        if(row == arr.length - 1) {
            sum += arr[row][col];
            store[0] = Math.min(store[0], sum);
            return;
        }
        sum += arr[row][col];
        //down
        minPath(arr, row + 1, col, store, sum);
        //diagonal right
        minPath(arr, row + 1, col + 1, store, sum);
        //diagonal left
        minPath(arr, row + 1, col - 1, store, sum);
    }
}

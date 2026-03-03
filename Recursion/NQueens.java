GFG
  class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[][] board = new int[n][n];
        placeQueen(board, res, list, 0, 0);
        return res;
    }
    public void placeQueen(int[][] board, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int row, int col) {
        //Base Case
        if(row == board.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        //Boundary check
        if(col >= board[0].length) return;
        //If valid place the queen
        if(isValid(board, row, col)) {
            //place the queen
            board[row][col] = 1;
            //Add the queen in your answer
            list.add(col + 1);
            //we can only place one queen at one col
            placeQueen(board, res, list, row + 1, 0);
            //During BackTracking remove the queen from your answer
            list.remove(list.size() - 1);
            //Unplace the queen
            board[row][col] = 0;
        }
        //Always Try next Colomn
        placeQueen(board, res, list, row, col + 1);
    }
    public boolean isValid(int[][] board, int row, int col) {
        //top check
        for(int i = row; i >= 0; i--) {
            if(board[i][col] == 1) return false;
        }
        //top left check
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) return false;
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if(board[i][j] == 1) return false;
        }
        //if Their is no queen placed in all these places then return true
        return true;
    }
}

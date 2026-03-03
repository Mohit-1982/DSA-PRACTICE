GFG
  class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        if(maze[0][0] == 0) return new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        genPath(maze, 0, 0, list, "");
        return list;
    }
    public void genPath(int[][] arr, int row, int col, ArrayList<String> list, String p) {
        if(row >= arr.length || col >= arr[0].length || row < 0 || col < 0 || arr[row][col] == 0) return;
        if(row == arr.length - 1 && col == arr[0].length - 1) {
            list.add(p);
            return;
        }
        arr[row][col] = 0;
        genPath(arr, row + 1, col, list, p + "D");
        genPath(arr, row, col - 1, list, p + "L");
        genPath(arr, row, col + 1, list, p + "R");
        genPath(arr, row - 1, col, list, p + "U");
        arr[row][col] = 1;
    }
}

Leetcode - 73
  Brute : O(n^3) and Space : O(n*m)
    class Pair{
    int row;
    int col;
    Pair(int row,int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        Stack<Pair> st = new Stack<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    st.add(new Pair(i,j));
                    //row, col
                }
            }
        }
        while(!st.isEmpty()) {
            Pair pop = st.pop();
            int i = pop.row;
            int j = pop.col;
            //Row Change
            for(int k = 0; k < n; k++) {
                matrix[k][j] = 0;
            }
            //Coloumn Change
            for(int l = 0; l < m; l++) {
                matrix[i][l] = 0;
            }
        }
    }
}

Better : Time : O(n*m) And Space : O(n + m)
  class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        int i = 0;
        while(i < n) {
            if(row[i] == true) {
                for(int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
            i++;
        }
        int j = 0;
        while(j < m) {
            if(col[j] == true) {
                for(int k = 0; k < n; k++) {
                    matrix[k][j] = 0;
                }
            }
            j++;
        }
    }
}

Optimal : Time : O(n * m) and Space : O(1)
  class Solution {
    public void setZeroes(int[][] matrix) {
        int count0 = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        //Find All rows and coloumns which we are going to make 0
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if(j != 0) matrix[0][j] = 0;
                    else count0 = 0;
                }
            }
        }
        //Now make all the row and col which needs to be zero except 1st row and col
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] != 0) {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        //Now make 1st row and col Zero according to their values
        if(matrix[0][0] == 0) {
            for(int i = 0; i < m; i++) matrix[0][i] = 0;
        }
        if(count0 == 0) {
            for(int i = 0; i < n; i++) matrix[i][0] = 0;
        } 
    }
}
  

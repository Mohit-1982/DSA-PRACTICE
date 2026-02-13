GFG
  class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int fr = 0;
        int fc = 0;
        int lr = n - 1;
        int lc = m - 1;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(fr <= lr && fc <= lc) {
            for(int i = fc; i <= lc; i++) {
                list.add(arr[fr][i]);
            }
            fr++;
            for(int i = fr; i <= lr; i++) {
                list.add(arr[i][lc]);
            }
            lc--;
            if(fr <= lr) {
                //if our first row is lesser than last then we are going add coloumn 
                //this will check we dont add the last row 2 times similarly for coloumns check
                for(int i = lc; i >= fc; i--) {
                list.add(arr[lr][i]);
            }
            lr--;
            }
            if(fc <= lc) {
                for(int i = lr; i >= fr; i--) {
                list.add(arr[i][fc]);
            }
            fc++;
            }
        }
        return list;
    }
}

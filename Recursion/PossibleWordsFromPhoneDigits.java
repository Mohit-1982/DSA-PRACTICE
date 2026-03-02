GFG
  class Solution {
    public ArrayList<String> possibleWords(int[] arr) {
        String[] charAtNum = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> res = new ArrayList<>();
        genWords(arr, charAtNum, 0, res);
        return res;
    }
    public void genWords(int[] arr, String[] charAtNum, int idx, ArrayList<String> res) {
        if(idx >= arr.length) {
            res.add("");
            return;
        }
        //this will skip 0 and 1 case
        if(charAtNum[arr[idx]].length() == 0) {
            genWords(arr, charAtNum, idx + 1, res);
            return;
        }
        ArrayList<String> list = new ArrayList<>();
        genWords(arr, charAtNum, idx + 1, list);
        String str = charAtNum[arr[idx]];
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for(String ele : list) {
                res.add(ch + ele);
            }
        }
    }
}

GFG
  Brute : O(n^3) and space : O(n^2)
    class Solution {
    public List<List<Integer>> getSubArrays(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                List<Integer> list = new ArrayList<>();
                for(int k = i; k <= j; k++) {
                    list.add(arr[k]);
                }
                ans.add(list);
            }
        }
        return ans;
    }
}

Optimal : O(n^2) Technically O(n^3) and Auxiliary Space : O(1)
  class Solution {
    public List<List<Integer>> getSubArrays(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = i; j < arr.length; j++) {
                list.add(arr[j]);
                ans.add(new ArrayList<>(list));
            }
        }
        return ans;
    }
}

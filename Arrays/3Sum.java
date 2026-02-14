GFG
  Brute : O(n^3)
    class Solution {
    public boolean hasTripletSum(int arr[], int target) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(arr[i] + arr[j] + arr[k] == target) return true;
                }
            }
        }
        return false;
    }
}
Optimal : O(n ^ 2) and O(1) Space
  class Solution {
    public static ArrayList<ArrayList<Integer>> triplets(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++) {
            //skip i duplicates            
            if(i > 0 && arr[i] == arr[i - 1]) continue;
            int j = i + 1;
            int k = arr.length - 1;
            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum > 0) {
                    k--;
                }else if(sum < 0) {
                    j++;
                }else {
                    list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);
                    ans.add(list);
                    j++;
                    k--;
                    //skip duplicates of j
                    while(j < k && arr[j] == arr[j - 1]) j++;
                    //skip duplicates of k
                    while(k > j && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return ans;
    }
}

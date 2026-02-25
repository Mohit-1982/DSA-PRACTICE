GFG
  Brute :
    class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,Node head) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        while(temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while(i < j) {
            int sum = list.get(i) + list.get(j);
            if(sum > target) {
                j--;
            }else if(sum < target) {
                i++;
            }else {
                ArrayList<Integer> store = new ArrayList<>();
                store.add(list.get(i));
                store.add(list.get(j));
                ans.add(store);
                i++;
                j--;
            }
        }
        return ans;
    }
}

Optimal :
  class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,Node head) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node i = head;
        Node j = head;
        while(j.next != null) {
            j = j.next;
        }
        while(i != null && j != null && i != j && i.prev != j) {
            int sum = i.data + j.data;
            if(sum > target) {
                j = j.prev;
            }else if(sum < target) {
                i = i.next;
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i.data);
                list.add(j.data);
                ans.add(list);
                i = i.next;
                j = j.prev;
            }
        }
        return ans;
    }
}

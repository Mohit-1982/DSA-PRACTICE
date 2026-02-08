GFG
  Brute :
  class Solution {
    int getSingle(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : arr) {
            if(set.contains(ele)) {
                set.remove(ele);
            }else {
                set.add(ele);
            }
        }
        return set.iterator().next();
    }
}

Optimal : 
  class Solution {
    int getSingle(int arr[]) {
        //Property of Xor(^) that it makes duplicates zero
        int ans = 0;
        for(int ele : arr) {
            ans ^= ele;
        }
        return ans;
    }
}

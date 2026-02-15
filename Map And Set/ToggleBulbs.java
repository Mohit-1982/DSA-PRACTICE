Leetcode - 3842
  class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int ele : bulbs) {
            if(!set.contains(ele)) {
                set.add(ele);
            }else {
                set.remove(ele);
            }
        }
        for(int ele : set) {
            list.add(ele);
        }
        Collections.sort(list);
        return list;
    }
}

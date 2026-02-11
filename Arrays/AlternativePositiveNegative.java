GFG
  class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) < 0) {
                neg.add(arr.get(i));
            }else {
                pos.add(arr.get(i));
            }
        }
        
        if(pos.size() > neg.size()) {
            for(int i = 0; i < neg.size(); i++) {
                arr.set(2 * i,pos.get(i));
                arr.set(2 * i + 1,neg.get(i));
            }
            //leftovers
            int idx = 2 * neg.size();
            for(int i = neg.size(); i < pos.size(); i++) {
                arr.set(idx,pos.get(i));
                idx++;
            }
        }else {
            for(int i = 0; i < pos.size(); i++) {
                arr.set(2 * i,pos.get(i));
                arr.set(2 * i + 1,neg.get(i));
            }
            //leftovers
            int idx = 2 * pos.size();
            for(int i = pos.size(); i < neg.size(); i++) {
                arr.set(idx,neg.get(i));
                idx++;
            }
        }
    }

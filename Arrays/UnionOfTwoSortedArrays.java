GFG
  Brute : Using HashSet
    class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for(int i = 0; i < b.length; i++) {
            set.add(b[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele : set) {
            list.add(ele);
        }
        Collections.sort(list);
        return list;
    }
}

Optimal : Using Two Pointers Approach
  class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        // if(a[i] < b[j]) {
        //     list.add(a[i]);
        //     i++;
        // }else {
        //     list.add(b[j]);
        //     j++;
        // }
        while(i < n && j < m) {
            int val;
            if(a[i] == b[j]) {
                //check is this exist or not inside the list
                // if(!list.isEmpty() && list.get(list.size() - 1) != a[i]) {
                //     list.add(a[i]);
                // }
                val = a[i];
                i++;
                j++;
            }else if(a[i] < b[j]) {
                // if(!list.isEmpty() && list.get(list.size() - 1) != a[i]) {
                //     list.add(a[i]);
                // }
                val = a[i];
                i++;
            }else {
                // if(!list.isEmpty() && list.get(list.size() - 1) != b[j]) {
                //     list.add(b[j]);
                // }
                val = b[j];
                j++;
            }
            if(list.isEmpty() || list.get(list.size() - 1) != val) {
                list.add(val);
            }
        }
        while(j < m) {
            if(list.isEmpty() || list.get(list.size() - 1) != b[j]) {
                    list.add(b[j]);
            }
            j++;
        }
        while(i < n) {
            if(list.isEmpty() || list.get(list.size() - 1) != a[i]) {
                    list.add(a[i]);
            }
            i++;
        }
        return list;
    }
}
    

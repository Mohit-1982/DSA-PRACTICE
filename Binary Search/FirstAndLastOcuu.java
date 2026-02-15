GFG
  Brute : O(n)
    class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) {
                if((i > 0 && arr[i - 1] != x) || i == 0) {
                    list.add(i);
                }
                if((i < arr.length - 1 && arr[i + 1] != x) || i == arr.length - 1) {
                    list.add(i);
                }
            }
        }
        if(list.isEmpty()) {
            list.add(-1);
            list.add(-1);
            return list;
        }else {
            return list;
        }
    }
}

Better : O(n)
  class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        int first = -1;
        int last = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) {
                if(first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(first);
        list.add(last);
        return list;
    }
}

Optimal : O(logn)
  class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        //First Occurance
        int first = -1;
        int s = 0;
        int e = arr.length - 1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(arr[m] < x) {
                s = m + 1;
            }else if(arr[m] > x) {
                e = m - 1;
            }else {
                first = m;
                e = m - 1;
            }
        }
        //Last Occurance
        int last = -1;
        s = 0;
        e = arr.length - 1;
        while(s <= e) {
            int m = s+ (e - s) / 2;
            if(arr[m] > x) {
                e = m - 1;
            }else if(arr[m] < x) {
                s = m + 1;
            }else {
                last = m;
                s = m + 1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(first);
        list.add(last);
        return list;
    }
}

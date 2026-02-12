GFG
  Brute : 
    class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            int top = arr[i];
            while(!st.isEmpty() && st.peek() < top) {
                st.pop();
            }
            st.push(top);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int size = st.size();
        for(int i = 0; i < size; i++) {
            list.add(0);
        }
        for(int i = size - 1; i >= 0; i--) {
            list.set(i,st.pop());
        }
        return list;
    }
}

Better :
  class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i = n - 1; i >= 0; i--) {
            if(st.isEmpty() || arr[i] >= st.peek()) {
                st.push(arr[i]);
            }
        }
        int size = st.size();
        for(int i = 0; i < size; i++) {
            list.add(st.pop());
        }
        return list;
    }
}

Optimal :
  Without Stack
    class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            while(!list.isEmpty() && arr[i] > list.get(list.size() - 1)) {
                list.remove(list.size() - 1);
            }
            list.add(arr[i]);
        }
        return list;
    }
}

Optimal :
  class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i = n - 1; i >= 0; i--) {
            if(arr[i] >= max) {
                max = arr[i];
                list.add(max);
            }
        }
        Collections.reverse(list);
        return list;
    }
}

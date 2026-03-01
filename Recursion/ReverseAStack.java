GFG
  class Solution {
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()) return;
        int top = st.pop();
        reverseStack(st);
        placeTop(st, top);
    }
    public static void placeTop(Stack<Integer> st, int top) {
        if(st.isEmpty()) {
            st.push(top);
            return;
        }
        if(!st.isEmpty()) {
            int ele = st.pop();
            placeTop(st, top);
            st.push(ele);
        }
    }
}

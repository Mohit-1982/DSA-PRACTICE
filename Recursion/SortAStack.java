GFG
  Iteratively : 
    class Solution {
    public void sortStack(Stack<Integer> st) {
        Stack<Integer> nst = new Stack<>();
        while(!st.isEmpty()) {
            int top = st.peek();
            if(nst.isEmpty()) {
                nst.push(top);
            }else {
                while(!nst.isEmpty() && nst.peek() > top) st.push(nst.pop());
                nst.push(top);
                while(!st.isEmpty() && st.peek() != top) nst.push(st.pop());
            }
            if(!st.isEmpty()) st.pop();
        }
        Stack<Integer> revSt = new Stack<>();
        while(!nst.isEmpty()) revSt.push(nst.pop());
        while(!revSt.isEmpty()) st.push(revSt.pop());
    }
}
Recursively : 
  class Solution {
    public void sortStack(Stack<Integer> st) {
        if(st.size() == 1) return;
        int top = st.pop();
        sortStack(st);
        //now place the element on its right position
        place(st, top);
    }
    public void place(Stack<Integer> st, int top) {
        if(st.isEmpty()) {
            st.push(top);
            return;
        }
        if(top < st.peek()) {
            int ele = st.pop();
            place(st, top);
            st.push(ele);
        }else {
            st.push(top);
        }
    }
}

GFG
  Brute : 
    class Solution {
    Node reverseList(Node head) {
        Stack<Node> st = new Stack<>();
        Node temp = head;
        while(temp != null) {
            st.push(temp);
            temp = temp.next;
        }
        Node dummy = new Node(-1);
        temp = dummy;
        while(!st.isEmpty()) {
            temp.next = st.pop();
            temp = temp.next;
        }
        temp.next = null;//Remove the last Node pointer otherwise it will create TLE
        return dummy.next;
    }
}
Optimal :
  class Solution {
    Node reverseList(Node head) {
        Node p = null;
        Node f = null;
        Node c = head;
        while(c != null) {
            f = c.next;
            c.next = p;
            p = c;
            c = f;
        }
        return p;
    }
}

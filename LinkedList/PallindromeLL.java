GFG
  class Solution {
    public boolean isPalindrome(Node head) {
        Stack<Node> st = new Stack<>();
        Node temp = head;
        while(temp != null) {
            st.push(temp);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            if(temp.data != st.pop().data) return false;
            temp = temp.next;
        }
        return true;
    }
}

Optimal : 
  class Solution {
    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = rev(slow);
        Node temp = head;
        fast = slow;
        while(fast != null) {
            if(temp.data != fast.data) return false;
            temp = temp.next;
            fast = fast.next;
        }
        return true;
    }
    public Node rev(Node head) {
        Node curr = head;
        Node prev = null;
        Node fwd = null;
        while(curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
}

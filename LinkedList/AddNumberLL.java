GFG
  class Solution {
    public Node addTwoLists(Node head1, Node head2) {
        Node temp = reverse(head1);
        Node temp2 = reverse(head2);
        int carry = 0;
        Node dummy = new Node(-1);
        Node t1 = dummy;
        int val = 0;
        int vall = 0;
        while(temp != null || temp2 != null) {
            val = (temp != null) ? temp.data : 0;
            vall = (temp2 != null) ? temp2.data : 0;
            int value = val + vall + carry;
            carry = value / 10;
            Node a = new Node(value % 10);
            t1.next = a;
            t1 = t1.next;
            if(temp != null) temp = temp.next;
            if(temp2 != null) temp2 = temp2.next;
        }
        if(carry == 1) {
            Node a = new Node(carry);
            t1.next = a;
        }
        temp = reverse(dummy.next);
        while(temp != null && temp.next != null) {
            if(temp.data != 0) break;
            temp = temp.next;
        }
        return temp;
    }
    public Node reverse(Node head) {
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

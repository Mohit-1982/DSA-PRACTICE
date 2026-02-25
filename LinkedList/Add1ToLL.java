GFG
  class Solution {
    public Node addOne(Node head) {
        Node temp = reverse(head);
        Node tempStore = temp;
        int carry = 1;
        Node prev = null;
        while(temp != null) {
            int value = temp.data + carry;
            if(value > 9) {
                value = 0;
                carry = 1;
            }else carry = 0;
            temp.data = value;
            prev = temp;
            temp = temp.next;
        }
        if(carry == 1) {
            Node a = new Node(1);
            prev.next = a;
        }
        temp = reverse(tempStore);
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

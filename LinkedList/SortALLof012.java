GFG
  class Solution {
    public Node segregate(Node head) {
        if(head == null || head.next == null) return head;
        Node d0 = new Node(-1);
        Node t0 = d0;
        Node d1 = new Node(-1);
        Node t1 = d1;
        Node d2 = new Node(-1);
        Node t2 = d2;
        Node temp = head;
        while(temp != null) {
            if(temp.data == 0) {
                t0.next = temp;
                t0 = t0.next;
            }else if(temp.data == 1) {
                t1.next = temp;
                t1 = t1.next;
            }else {
                t2.next = temp;
                t2 = t2.next;
            }
            temp = temp.next;
        }
        t1.next = d2.next;
        t0.next = d1.next;
        t2.next = null;
        return d0.next;
    }
}

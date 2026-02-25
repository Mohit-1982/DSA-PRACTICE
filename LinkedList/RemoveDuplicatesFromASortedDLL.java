GFG
  class Solution {
    Node removeDuplicates(Node head) {
        if(head == null) return null;
        Node dummy = new Node(head.data - 1);
        Node temp = head;
        Node t1 = dummy;
        while(temp != null) {
            if(temp.data != t1.data) {
                t1.next = temp;
                temp.prev = t1;
                t1 = t1.next;
            }
            temp = temp.next;
        }
        t1.next = null;
        dummy = dummy.next;
        dummy.prev = null;
        return dummy;
    }
}

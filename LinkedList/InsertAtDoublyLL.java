GFG
  class Solution {
    Node insertAtPos(Node head, int p, int x) {
        if(head == null) return head;
        Node temp = head;
        for(int i = 0; i < p; i++) {
            temp = temp.next;
        }
        if(temp != null && temp.next == null) {
            Node a = new Node(x);
            temp.next = a;
            a.prev = temp;
            return head;
        }else {
            Node a = new Node(x);
            a.next = temp.next;
            temp.next = a;
            a.next.prev = a;
            a.prev = temp;
            return head;
        }
    }
}

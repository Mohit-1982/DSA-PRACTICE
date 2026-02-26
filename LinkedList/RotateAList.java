GFG
  class Solution {
    public Node rotate(Node head, int k) {
        if(head == null || head.next == null) return head;
        Node temp = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        k %= size;
        if(k == 0) return head;
        temp = head;
        for(int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        if(temp.next == null) return head;
        Node a = temp.next;
        Node newHead = a;
        temp.next = null;
        while(a.next != null) a = a.next;
        a.next = head;
        return newHead;
    }
}

More Readable : 
  class Solution {
    public Node rotate(Node head, int k) {
        if(head == null || head.next == null) return head;
        Node temp = head;
        int size = 1;
        while(temp.next != null) {
            size++;
            temp = temp.next;
        }
        temp.next = head;
        k %= size;
        if(k == 0) {
            temp.next = null;
            return head;
        }
        temp = head;
        for(int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        Node a = temp.next;
        temp.next = null;
        return a;
    }
}

GFG
  class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node temp = head;
        while(temp != null && temp.data == x) {
            temp = temp.next;
        }
        if(temp == null) return null;
        Node store = temp;
        store.prev = null;
        Node t1 = temp;
        temp = temp.next;
        while(temp != null) {
            if(temp.data != x) {
                t1.next = temp;
                temp.prev = t1;
                t1 = t1.next;
            }
            temp = temp.next;
        }
        t1.next = null;
        return store;
    }
}

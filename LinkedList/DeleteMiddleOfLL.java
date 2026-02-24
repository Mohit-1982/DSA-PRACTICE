GFG
  class Solution {
    Node deleteMid(Node head) {
        if(head == null || head.next == null) return null;
        Node temp = null;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = slow.next;
        return head;
    }
}

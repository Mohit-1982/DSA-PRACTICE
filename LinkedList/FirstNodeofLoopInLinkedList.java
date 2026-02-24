GFG
  class Solution {
    public int cycleStart(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return -1;
        Node temp = head;
        while(temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }
        return slow.data;
    }
}

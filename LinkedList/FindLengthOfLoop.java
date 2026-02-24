GFG
  class Solution {
    public int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return 0;
        int size = 1;
        slow = slow.next;
        while(slow != fast) {
            size++;
            slow = slow.next;
        }
        return size;
    }
}

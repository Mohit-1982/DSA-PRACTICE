Leetcode - 203
  class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head != null) {
            if(head.val != val) {
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = null;
        return dummy.next;
    }
}

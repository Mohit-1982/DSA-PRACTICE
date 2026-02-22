GFG
  Recursive Approach : 
    class Solution {
    public int getCount(Node head) {
        return helper(head, 0);
    }
    public int helper(Node head, int idx) {
        if(head == null) return idx;
        return helper(head.next, idx + 1);
    }
}

Iterative Appraoch : 
  class Solution {
    public int getCount(Node head) {
        Node temp = head;
        int len = 0;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
}

GFG
  Brute :
  class Solution {
    public Node reverse(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        while(temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }
        Node dummy = new Node(-1);
        temp = dummy;
        for(int i = list.size() -1; i >= 0; i--) {
            Node a = new Node(list.get(i));
            temp.next = a;
            a.prev = temp;
            temp = temp.next;
        }
        dummy = dummy.next;
        dummy.prev = null;
        return dummy;
    }
}

Optimal :
  class Solution {
    public Node reverse(Node head) {
        if(head == null) return head;
        Node p = null;
        Node curr = head;
        Node f = null;
        while(curr != null) {
            f = curr.next;
            curr.next = p;
            p = curr;
            curr = f;
            p.prev = curr;
        }
        return p;
    }
}

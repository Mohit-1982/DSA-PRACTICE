GFG
  Brute : 
    class Solution {
    Node divide(Node head) {
        ArrayList<Node> even = new ArrayList<>();
        ArrayList<Node> odd = new ArrayList<>();
        Node temp = head;
        while(temp != null) {
            if(temp.data % 2 == 0) {
                even.add(temp);
            }else {
                odd.add(temp);
            }
            temp = temp.next;
        }
        Node d1 = new Node(-1);
        temp = d1;
        for(int i = 0; i < even.size(); i++) {
            temp.next = even.get(i); 
            temp = temp.next;
        }
        for(int i = 0; i < odd.size(); i++) {
            temp.next = odd.get(i);
            temp = temp.next;
        }
        temp.next = null;
        return d1.next; 
    }
}

Optimal :
  class Solution {
    Node divide(Node head) {
        Node d1 = new Node(-1);
        Node d2 = new Node(-1);
        Node odd = d1;
        Node even = d2;
        Node temp = head;
        while(temp != null) {
            if(temp.data % 2 == 0) {
                even.next = temp;
                even = even.next;
            }else {
                odd.next = temp;
                odd = odd.next;
            }
            temp = temp.next;
        }
        odd.next = null;
        even.next = d1.next;
        return d2.next;
    }
}

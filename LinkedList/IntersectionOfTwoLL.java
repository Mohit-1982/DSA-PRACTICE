GFG
  Brute : 
    class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();
        Node temp = head1;
        while(temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        temp = head2;
        while(temp != null) {
            list2.add(temp);
            temp = temp.next;
        }
        int i = 0;
        if(list.size() < list2.size()) {
            i = list2.size() - list.size();
            int j = 0;
            while(i < list2.size() && j < list.size()) {
                if(list2.get(i) == list.get(j)) return list.get(j);
                i++;
                j++;
            }
        }else {
            i = list.size() - list2.size();
            int j = 0;
            while(i < list.size() && j < list2.size()) {
                if(list.get(i) == list2.get(j)) return list.get(i);
                i++;
                j++;
            }
        }
        return null;
    }
}

Optimal : 
  class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        Node temp = head1;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        temp = head2;
        int size1 = 0;
        while(temp != null) {
            size1++;
            temp = temp.next;
        }
        if(size > size1) {
            Node check1 = head1;
            Node check2 = head2;
            for(int i = 0; i < size - size1; i++) {
                check1 = check1.next;
            }
            while(check1 != null && check2 != null) {
                if(check1 == check2) return check1;
                check1 = check1.next;
                check2 = check2.next;
            }
        }else {
            Node check1 = head2;
            Node check2 = head1;
            for(int i = 0; i < size1 - size; i++) {
                check1 = check1.next;
            }
            while(check1 != null && check2 != null) {
                if(check1 == check2) return check1;
                check1 = check1.next;
                check2 = check2.next;
            }
        }
        return null;
    }
}

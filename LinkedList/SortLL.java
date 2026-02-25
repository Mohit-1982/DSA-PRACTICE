GFG
  Brute : 
    class Solution {
    public static Node insertionSort(Node head) {
        if(head == null) return null;
        Node temp = head;
        ArrayList<Node> list = new ArrayList<>();
        while(temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        mergeSort(list);
        temp = list.get(0);
        for(int i = 0; i < list.size() - 1; i++) {
            temp.next = list.get(i + 1);
            temp = temp.next;
        }
        temp.next = null;
        return list.get(0);
    }
    public static void mergeSort(ArrayList<Node> list) {
        if(list.size() == 1) return;
        ArrayList<Node> a = new ArrayList<>();
        ArrayList<Node> b = new ArrayList<>();
        int n = list.size();
        int k = 0;
        for(int i = 0; i < (n >> 1); i++) a.add(list.get(k++));
        for(int i = 0; i < n - (n >> 1); i++) b.add(list.get(k++));
        mergeSort(a);
        mergeSort(b);
        merge(a, b, list);
    }
    public static void merge(ArrayList<Node> a, ArrayList<Node> b, ArrayList<Node> list) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a.size() && j < b.size()) {
            if(a.get(i).data < b.get(j).data) list.set(k++, a.get(i++));
            else list.set(k++, b.get(j++));
        }
        while(i < a.size()) list.set(k++, a.get(i++));
        while(j < b.size()) list.set(k++, b.get(j++));
    }
}

Optimal : TC : O(nlogn) and SC : O(logn) because we are not using any extra space to store list
  class Solution {
    public static Node insertionSort(Node head) {
        if(head == null) return null;
        head = sort(head);
        return head;
    }
    public static Node sort(Node head) {
        if(head == null || head.next == null) return head;
        //find half of list
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;//Break the linkage
        
        slow = sort(head);
        fast = sort(fast);
        Node newHead = merge(slow, fast);
        return newHead;
    }
    public static Node merge(Node head1, Node head2) {
        Node t = head1;
        Node m = head2;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(t != null && m != null) {
            if(t.data < m.data) {
                temp.next = t;
                t = t.next;
            }else {
                temp.next = m;
                m = m.next;
            }
            temp = temp.next;
        }
        while(t != null) {
            temp.next = t;
            t = t.next;
            temp = temp.next;
        }
        while(m != null) {
            temp.next = m;
            m = m.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}

GFG
  Brute : 
    class Solution {
    int getMiddle(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        for(Node temp = head; temp != null; temp = temp.next) {
            list.add(temp.data);
        }
        return list.get(list.size() / 2);
    }
}
Better :
  class Solution {
    int getMiddle(Node head) {
        int size = 0;
        Node temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        temp = head;
        for(int i = 0; i < size / 2; i++) temp = temp.next;
        return temp.data;
    }
}
Optimal : Tortoise Method Slow and Fast pointers
  class Solution {
    int getMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}

package LinkedList.DoublyLL;
class Node{
    int val;
    Node next;
    Node prev;
    Node(int val) {
        this.val = val;
    }
}
class DoublyLL{
    Node head;
    Node tail;
    int size = 0;
    void insertAtHead(int val) {
        Node a = new Node(val);
        if(head == null) head = tail = a;
        else {
            a.next = head;
            head.prev = a;
            head = head.prev;
        }
        size++;
    }
    void insertAtTail(int val) {
        Node a = new Node(val);
        if(tail == null) head = tail = a;
        else {
            tail.next = a;
            a.prev = tail;
            tail = tail.next;
        }
        size++;
    }
    void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
    int size() {
        return size;
    }
    boolean isEmpty() {
        return (size() == 0) ? true : false;
    }
    void insertAtIndex(int idx, int val) {
        if(idx > size) {
            System.out.println("Invalid Index !!!");
            return;
        }
        if(idx == 0) {
            insertAtHead(val);
            return;
        }
        if(idx == size) {
            insertAtTail(val);
            return;
        }
        Node a = new Node(val);
        Node temp = head;
        for(int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        a.next = temp.next;
        temp.next = a;
        a.prev = temp;
        temp = a.next;
        temp.prev = a;
        size++;
    }
    void deleteAtHead() {
        if(head == null) {
            System.out.println("First Add Values");
            return;
        }
        if(head.next == null) head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    void deleteAtTail() {
        if(tail == null) {
            System.out.println("First Add Values");
            return;
        }
        if(tail.prev == null) head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }
    void deleteAtIndex(int idx) {
        if(head == null) {
            System.out.println("First Add Values");
            return;
        }
        if(idx == 0) {
            deleteAtHead();
            return;
        }
        if(idx == size - 1) {
            deleteAtTail();
            return;
        }
        if(idx >= size || idx < 0) {
            System.out.println("Enter Valid Index");
            return;
        }
        Node temp = head;
        for(int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }
}
public class ImplementDoublyLL {
    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();
        list.insertAtTail(10); list.insertAtTail(20);
        list.insertAtTail(30); list.insertAtTail(40);
        list.insertAtTail(50); list.insertAtHead(60);
        list.insertAtTail(70); list.insertAtTail(80);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.deleteAtTail();
        list.deleteAtHead();
        list.deleteAtIndex(4);
        list.display();
    }
}

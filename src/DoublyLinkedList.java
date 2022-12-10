import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode{
        private int data;
        private ListNode prev;
        private ListNode next;

        private ListNode(int data){
            this.data = data;
        }
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    private boolean isEmpty(){
        return length == 0;
    }

    private int length(){
        return length;
    }

    private void displayForward(){
        if(head == null){
            return;
        }
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private void displayBackward(){
        if(tail == null){
            return;
        }
        ListNode temp = tail;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    private void insertLast(int value){
        ListNode newNode = new ListNode(value);

        if(isEmpty()){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
        length++;
    }

    private void insertFirst(int value){
        ListNode newNode = new ListNode(value);

        if(isEmpty()){
            tail = newNode;
        }
        else{
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    private ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        ListNode temp = head;
        if(head == tail){       //Head and Tail points to the same node
            tail = null;
        }
        else{
            head.next.prev = null;  //Unlinking node from the next node back to itself
        }
        head = head.next;
        temp.next = null;
        return temp;
    }

    private ListNode deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        ListNode temp = tail;
        if(head == tail){       //Head and Tail points to the same node
            head = null;
        }
        else{
            tail.prev.next = null;  //Unlinking node from the next node back to itself
        }
        tail = tail.prev;
        temp.prev = null;
        return temp;
    }


    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertFirst(1);
        dll.insertFirst(2);
        dll.insertFirst(6); //6215
        dll.insertLast(5);
        dll.displayForward();
        //dll.displayBackward();

        System.out.println("Deleted Node: " + dll.deleteFirst().data);
        dll.displayForward();
        System.out.println("Deleted Node: " + dll.deleteLast().data);
        dll.displayForward();


    }
}

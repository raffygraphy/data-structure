import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    //Constructor for CircularLinkedList
    public CircularSinglyLinkedList(){
        last = null;
        length = 0;
    }

    private boolean isEmpty(){
        return length == 0;
    }

    private int length(){
        return length;
    }

    //Displaying
    public void display(){
        ListNode first = last.next;

        while(first != last){
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    public void insertFirst(int data){
        ListNode temp = new ListNode(data);

        if(last == null){
            last = temp;
        }
        else{
            temp.next = last.next;      //Last.next is pointing sa last or basta sa iyang self
        }
        last.next = temp;               //Necessary if you still want it to be circular
        length++;
    }

    public void insertEnd(int data){
        ListNode temp = new ListNode(data);

        if(last == null){
            last = temp;
            last.next = last;       //Go back to yourself
        }
        else{
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }

        length++;
    }

    public ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        ListNode temp = last.next;          // First Node equal to the last.next circular things
        if(last.next == last){
            last = null;
        }
        else{
            last.next = temp.next;
        }
        temp.next = null;
        return temp;
    }


    //    public ListNode deleteLast(){
//        if(isEmpty()){
//            throw new NoSuchElementException();
//        }
//
//        ListNode temp = last.next;
//        ListNode checker = temp;
//        ListNode newLast;
//
//        if(last.next == last){
//            last = null;
//        }
//        else{
//            while(checker != null){
//                checker = checker.next;
//                if(checker.next == last){
//                    newLast = checker;
//                    checker = last;
//                    newLast.next = temp;
//                    last.next = null;
//                    last = newLast;
//                    break;
//                }
//            }
//        }
////        newLast = checker;
////        checker = last;
////        newLast.next = temp;
////        last.next = null;
////        last = newLast;
//
//        return checker;
//    }
    public ListNode deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        ListNode temp = last.next;
        ListNode checker = temp;
        ListNode newLast;

        if(last.next == last){
            last = null;
        }
        else{
            while(checker.next != last){
                checker = checker.next;
            }
        }
        newLast = checker;
        last.next = null;
        last = newLast;
        newLast = newLast.next;
        last.next = temp;
        return newLast;
    }


    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.insertFirst(1);
        csll.insertFirst(2);
        csll.insertFirst(3);
        csll.insertFirst(4);
        csll.insertFirst(5);

        csll.display();
        System.out.println("Number of Nodes" + csll.length());

        csll.insertEnd(6);
        csll.insertEnd(7);

        csll.display();
        System.out.println("Number of Nodes: " + csll.length());
        System.out.println("Deleted First Node: " + csll.deleteFirst().data);

        csll.display();

        System.out.println("Deleted Last Node: " + csll.deleteLast().data);
        csll.display();
    }
}

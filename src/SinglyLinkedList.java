public class SinglyLinkedList {

    private ListNode head;
    public int size = 0;


    public static class ListNode{
        public Object data;
        private ListNode next;


        //Constructor
        public ListNode(Object data) {
            this.data = data;
            this.next = null;
        }

    }

    //Display the Data
    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public void timeRunning(){
        double now = System.currentTimeMillis();
        System.out.print("Time Taken: ");
        System.out.println(System.currentTimeMillis()-now);
    }

    public Object first(){
        if(head == null) {
            return 0;
        }
        else{
            return head.data;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //Identifying the number of the Nodes
    public int length(){
        if(head == null) {
            return 0;
        }
        ListNode current = head;
        int counter = 0;
        for(;current != null; counter++){
            current = current.next;
        }
        return counter;
    }

    //Inserting new nodes at the beginning
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    //Inserting new nodes at the end of the node
    public Object insertLast(Object value){
        ListNode newNode = new ListNode(value);

        if(isEmpty()){
            head = newNode;
        }

        //Assign head to the current to check
        ListNode current = head;

        //Check if a node already existed, if true din it will point to another node
        while (current.next != null){
            current = current.next;
        }

        //If ang current.next is == null then, this will point your last node "null" to the newly added node
        current.next = newNode;
        size++;
        return current.next.data;
    }

//    public void insertLast(Object value){
//        ListNode newNode = new ListNode(value);
//        if(isEmpty()){
//            head = newNode;
//        }
//        else{
//            ListNode current = head.next;
//        }
//    }


    public ListNode deleteFirst(){
        if(head == null){
            return null;
        }

        size--;
        ListNode tempNode = head;
        head = head.next;
        tempNode.next = null;
        return tempNode;
    }

    public ListNode deleteLast(){
        //this will automatically delete the one last node by returning head
        if(head == null || head.next == null) {
            return head;
        }

        //Create Pointer, Current will travel to the last node, while prevNode will remain behind of the current
        ListNode current = head;
        ListNode prevNode = null;

        size--;
        while(current.next != null){
            prevNode = current;
            current = current.next;
        }

        prevNode.next = null;       //Cutting the link between the last node and its previous node
        return current;             //Can be seen using .data
    }

    //Inserting node at a desired position
    public void insertDesiredPos(double value, int position) {
        ListNode newNode = new ListNode(value);

        //First position
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        }
        //Certain position, we must travel back to a position before the desired position
        else {
            ListNode prevNode = head;
            int count = 1;
            while (count < position - 1) {
                prevNode = prevNode.next;
                count++;
            }

            size++;
            //Before breaking the link between the original sequence of the node, create a temporary current node to connect first
            ListNode current = prevNode.next;
            newNode.next = current;
            prevNode.next = newNode;
        }
    }

    public ListNode deleteDesiredPos(int position){
        ListNode deletedNode = null;

        if ( position == 1){
            head = head.next;       //head==null
        }
        else{
            ListNode prevNode = head;

            int count = 1;
            while (count < position - 1){         //This is for travelling to the nodes before the desired nodes to be deleted
                prevNode = prevNode.next;
                count++;
            }

            ListNode current = prevNode.next;
            prevNode.next = current.next;
            deletedNode = current;
            size--;
        }
        return deletedNode;
    }


    public static void main (String[]args){
        SinglyLinkedList sll = new SinglyLinkedList();

//            //Assigning the data
//            sll.head = new ListNode(10);
//            ListNode second = new ListNode(1);
//            ListNode third = new ListNode(8);
//            ListNode fourth = new ListNode(11);
//
//            //Pointing the data
//            sll.head.next = second;
//            second.next = third;
//            third.next = fourth;
//
//            System.out.println("\n10 --> 1 --> 8 --> 11 --> null");

        //Inserting new Nodes at the beginning
        sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(3);
        sll.insertFirst(2);
        sll.insertFirst(1);

        sll.insertLast(6);
        sll.insertLast(7);
        sll.insertLast(8);

        sll.display();
        System.out.println("\n");


        sll.insertDesiredPos(4.75,5);
        sll.insertDesiredPos(4.5,5);
        sll.insertDesiredPos(7.5,8);
        sll.insertDesiredPos(1.5,2);
        sll.insertDesiredPos(1.35,2);

        sll.display();

        System.out.println("\nDeleted First: " + sll.deleteFirst().data);                  //1.0 is deleted from the original Singly Linked List
        System.out.println("Deleted Last: " + sll.deleteLast().data);                   //8.0 is deleted from the original Singly Linked List
        System.out.println("Deleted Last: " + sll.deleteLast().data);                   //7.0 is deleted from the original Singly Linked List

        sll.display();

        System.out.println("\nDeleted Desired Node at Position 5: " + sll.deleteDesiredPos(5).data);
        System.out.println("Deleted Desired Node at Position 2: " + sll.deleteDesiredPos(2).data);

        sll.display();

        System.out.println("\nLength is - " + sll.length());
        sll.timeRunning();
    }

}

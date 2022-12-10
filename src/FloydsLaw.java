import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FloydsLaw {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void insertEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void removeDuplicate() {
        ListNode current = head;
        ListNode checker;
        ListNode linker;

        if (head == null) {
            return;
        }

        while (current != null) {
            linker = current;
            checker = current.next;

            while (checker != null) {
                if (current.data == checker.data) {
                    linker.next = checker.next;
                } else {
                    linker = checker;
                }
                checker = checker.next;
            }
            current = current.next;
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<Integer> inputArray = new ArrayList<>();

        String input = s.nextLine();
        String[] str = input.split(" ");

        List<String> list;
        list = Arrays.asList(str);
        for (String temp: list) {
            inputArray.add(Integer.parseInt(String.valueOf(temp)));
        }

//        String trial = "hello im sad";
//        String[] str2 = trial.split(" ");
//        List<String> trialList = Arrays.asList(str2);

        FloydsLaw sll = new FloydsLaw();

        for (int i : inputArray) {
            sll.insertEnd(i);
        }

        sll.removeDuplicate();
        sll.display();

        //System.out.println("The list is: " + list);
        //System.out.println("The list is: " + trialList);
    }
}


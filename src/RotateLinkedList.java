import java.util.*;

public class RotateLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode rotateRight(ListNode head, int k) {




        if (head == null ) {
            return null;
        }
        if (head.next == null) {
            return head;
        }


        //ListNode curr = head;
        ListNode curr = head;
        int counter = 0;

        while (counter != k) {
            if ( curr.next.next == null ) {
                curr.next.next = head;
                head = curr.next;
                curr.next = null;
                counter++;
                System.out.println("OK");
                curr = head;
                //break;
            }else {
            curr = curr.next;}
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        ListNode nk = new ListNode(1);
        nk.next = new ListNode(2);


        ListNode n1 = rotateRight(nk, 2);
        //ListNode h1 = deleteDuplicates(n);
        while(n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }


    }
}

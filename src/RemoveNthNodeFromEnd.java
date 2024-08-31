import java.util.*;


public class RemoveNthNodeFromEnd {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //one element edge case
        if (head.next == null) {
            return null;
        }
        //checking the size
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }



        ListNode prev = head;
        int start = len  - n ;
        int count = 1;
        while (count != start) {
            prev = prev.next;
            count++;
        }

        prev.next = prev.next.next;
        return head;
    }



    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(3);
        n.next.next.next.next = new ListNode(3);
        n.next.next.next.next.next = new ListNode(4);
        n.next.next.next.next.next.next = new ListNode(4);
        ListNode n1 = removeNthFromEnd(n, 3);

        while(n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }




    }
}

import java.util.*;

public class RemoveDuplicates {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode deleteNode(ListNode head, int del) {
        while (head.val == del) {
            head = head.next;
        }
        ListNode prev = head;
        ListNode curr = head.next;

        while(curr.next != null) {
            if (curr.val == del) {
                curr = curr.next;
                prev.next = curr;
            }else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return head;
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr.next != null) {
            if (curr.next.val == curr.val) {
                ListNode new_head = deleteNode(head, curr.val);
                head = new_head;
                prev = head;
                curr = head.next;
            }
            prev = prev.next;
            curr = curr.next;
        }
        return head;
    }


/*    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr.next != null) {
            if(curr.next.val == curr.val) {
                ListNode temp = curr.next.next;
                curr.next.next = null;
                curr.next = temp;
            }
            curr = curr.next;
        }
        return head;
    } */

    public static void main(String[] args) {

        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(3);
        n.next.next.next.next = new ListNode(3);
        n.next.next.next.next.next = new ListNode(4);
        n.next.next.next.next.next.next = new ListNode(4);

        ListNode n1 = deleteDuplicates(n);
        //ListNode h1 = deleteDuplicates(n);
        while(n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }
    }
}

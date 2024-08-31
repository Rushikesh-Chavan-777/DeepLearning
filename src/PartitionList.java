import java.util.*;

public class PartitionList {
//creating the ListNode class
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public static ListNode deleteNode(ListNode head, int val) {
        //System.out.println("deleting" + val);
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            head = head.next;
            return head;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
                break;
            }
            prev = prev.next;
        }
        return head;
    }
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode curr1 = head;
        while(curr1 != null) {
            if(curr1.val < x) {
                ListNode ya = new ListNode(curr1.val);
                curr.next = ya;
                curr = curr.next;
                head = deleteNode(head, curr1.val);
                curr1 = head;
            }else{
                curr1 = curr1.next; }

        }
        //System.out.println("OK"+ head.val);
        curr.next = head;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(2);
        n.next = new ListNode(1);
        //n.next.next = new ListNode(3);
        //n.next.next.next = new ListNode(2);
        //n.next.next.next.next = new ListNode(5);
        //n.next.next.next.next.next = new ListNode(2);
        //n.next.next.next.next.next.next = new ListNode(7);
        //testing the function
        ListNode n1 = partition(n, 2);
        while(n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }

    }
}

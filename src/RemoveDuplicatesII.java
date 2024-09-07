import java.util.*;

public class RemoveDuplicatesII {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while(head != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            if(prev.next == head) {
                prev = prev.next;
            }else{
                prev.next = head.next;
            }
            head = head.next;
        }
        return dummy.next;

    }
    public static void main(String[] args) {



        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(3);
        n.next.next.next.next = new ListNode(5);

        ListNode n1 = deleteDuplicates(n);
        //ListNode h1 = deleteDuplicates(n);
        while(n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }





    }
}

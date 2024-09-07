import java.util.*;

public class ReverseNodesInKGroup {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverse(ListNode node)
    {
        // doing the initialization
        // of as per the steps defined
        ListNode previous = null;
        ListNode curr = node;
        ListNode next = null;


        while (curr != null)
        {
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        node = previous;
        return node;
    }


    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        ListNode newer = dummy;
        ListNode temp  = new ListNode(0);
        ListNode temp1 = temp;
        int counter = 0;
        while(head != null) {
            while(counter < k && head != null) {
                temp1.next = new ListNode(head.val);
                head = head.next;
                temp1 = temp1.next;
                counter++;
                System.out.println("OK");
            }
            System.out.println(counter);

            if (counter == k) {
                System.out.println("ya");
                System.out.println(reverse(temp1).val);
                newer.next = reverse(temp1);
                newer = newer.next;
                counter = 0;
                temp.next = null;
                temp1 = temp;
            }else if (counter < k) {
                newer.next = temp.next;
                counter = 0;
                return dummy.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {


        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);


        ListNode n1 = reverseKGroup(n, 2);
        //ListNode h1 = deleteDuplicates(n);
        while(n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }
    }
}

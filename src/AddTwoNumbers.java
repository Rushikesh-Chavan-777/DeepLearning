import java.util.*;

public class AddTwoNumbers {

      //Definition for singly-linked list.
   public static class ListNode {
       int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode reverse(ListNode head) {
       if(head == null || head.next == null) {
           return head;
       }
       ListNode newnode = reverse(head.next);
       head.next.next = head;
       head.next = null;
       return newnode;
    }
    public static void addTwoNumbers(ListNode l1, ListNode l2) {
       l1 = reverse(l1);
       System.out.println(l1.val);
       l2 = reverse(l2);
       String s1 = "";
       String s2 = "";
        StringBuilder s1Builder = new StringBuilder();
        StringBuilder s2Builder = new StringBuilder();
        while(l1 != null) {
           s1Builder.append(l1.val);
           l1 = l1.next;
       }
        s1 = s1Builder.toString();
       while(l2 != null) {
           s2Builder.append(l2.val);
           l2 = l2.next;
       }
        s2 = s2Builder.toString();
       int a = Integer.parseInt(s1);
       int b = Integer.parseInt(s2);
       int c = a + b;
       String cs = String.valueOf(c);
        ListNode l3 = new ListNode();
       for (Character sd : cs.toCharArray()) {
           l3.val = sd - '0';
           l3 = l3.next;
       }
        System.out.println(l3.val);

    }


    public static void main(String[] args) {
       ListNode head = new ListNode(3);
       head.next = new ListNode(1);
       head.next.next = new ListNode(2);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        addTwoNumbers(head, head2);

    }
}

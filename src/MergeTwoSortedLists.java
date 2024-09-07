import java.util.*;

public class MergeTwoSortedLists {


        public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;


            while(list1 != null && list2!= null) {
                if(list1.val < list2.val) {
                    curr.next = list1;
                    list1 = list1.next;
                }
                else {
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            }
            //appending if anything is remaining
        if (list1 != null) {
            curr.next = list1;
        }else if (list2 != null) {
            curr.next = list2;
        }


        return dummy.next;

    }
    public static void main(String[] args) {


        ListNode n = new ListNode();
        //n.next = new ListNode(2);
        //n.next.next = new ListNode(4);
       //n.next.next.next = new ListNode(3);
       //n.next.next.next.next = new ListNode(3);
        //n.next.next.next.next.next = new ListNode(4);
        //n.next.next.next.next.next.next = new ListNode(4);


        ListNode n1 = new ListNode(0);
        //n1.next = new ListNode(3);
        //n1.next.next = new ListNode(4);
        //n1.next.next.next = new ListNode(3);
        //n1.next.next.next.next = new ListNode(3);
        //n1.next.next.next.next.next = new ListNode(4);
        //n1.next.next.next.next.next.next = new ListNode(4);


        ListNode ans = mergeTwoLists(n, n1);
        //ListNode h1 = deleteDuplicates(n);
        while(ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

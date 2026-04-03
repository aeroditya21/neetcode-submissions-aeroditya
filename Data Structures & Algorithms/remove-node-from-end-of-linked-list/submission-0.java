/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Move last forward n times from head
        ListNode last = head;
        for (int i=1; i<n; i++) {
            if(last == null) { 
                return head;
            }
            last = last.next;
        }

        // Till last reaches terminal, iterate prev & curr along with next
        ListNode prev = null;
        ListNode curr = head;
        while(last.next != null) {
            prev = (prev==null)?(head):(prev.next);
            curr = curr.next;
            last = last.next;
        }

        // Remove curr node by pointing prev to curr -> next
        if (prev == null) {
            head = curr.next;
        } else {
            prev.next = curr.next;
        }

        return head;
    }
}

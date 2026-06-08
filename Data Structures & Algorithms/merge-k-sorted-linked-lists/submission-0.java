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
    public ListNode mergeKLists(ListNode[] lists) {
        // Create & maintain a k-sized min-heap of ListNode heads of each list
        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        ListNode resHead = null, resItr = null;
        // Till the minHeap is empty
        while (!minHeap.isEmpty()) {
            // pop from heap and add next element of list in heap
            ListNode popped = minHeap.remove();
            System.out.println("Popped node val = " + popped.val);
            // place popped element on new linked list
            if (resItr == null) {
                resHead = popped;
                resItr = popped;
            } else {
                resItr.next = popped;
                resItr = popped;
            }
            
            // Add popped element's next onto minHeap
            if (popped.next != null) {
                minHeap.add(popped.next);
            }
            popped.next = null;
        }
        
        return resHead;
    }
}

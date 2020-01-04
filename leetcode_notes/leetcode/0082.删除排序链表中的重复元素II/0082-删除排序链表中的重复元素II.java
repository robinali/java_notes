/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 82
    // Reference: cspiration
    // Time: O(n) Space: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null && p.next.next != null) {
            if(p.next.val == p.next.next.val) {
                int sameNum = p.next.val;
                while(p.next != null && p.next.val == sameNum) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
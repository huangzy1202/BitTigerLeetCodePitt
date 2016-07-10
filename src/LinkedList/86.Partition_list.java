/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode slowHead = new ListNode(0); 
        ListNode slow = slowHead;
        
        ListNode fastHead = new ListNode(x);
        ListNode fast = fastHead;
        
        ListNode cur = head;
        
        while(cur != null) {
            ListNode tmp = cur.next;
            if(cur.val < x) {
                slow.next = cur;
                slow = cur;
            } else {
                fast.next = cur;
                fast = cur;
            }
            cur = tmp;
        }
        slow.next = fastHead.next;
        fast.next = null; //to avoid circle (when the last current node(tail) is not in the fast list)
        return slowHead.next;
    }
}

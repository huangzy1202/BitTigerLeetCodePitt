public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) {
           return head; 
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode runner = fakeHead;
        int cnt = 0;

        while(runner != null) {
            if(cnt == m - 1) {
                ListNode newHead = new ListNode(0);
                ListNode tmpRunner = runner.next;
                cnt++;
                while (cnt <= n && tmpRunner != null) {
                    ListNode tmpNext = tmpRunner.next;
                    tmpRunner.next = newHead.next;
                    newHead.next = tmpRunner;
                    tmpRunner = tmpNext;
                    cnt++;
                }
                runner.next.next = tmpRunner;
                runner.next = newHead.next;
                break;
            } else {
                runner = runner.next;
                cnt++;
            }
        }
        
        return fakeHead.next;
    }
}

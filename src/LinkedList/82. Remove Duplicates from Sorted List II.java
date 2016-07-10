public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        ListNode fakeRunner = fakeHead;
        ListNode runner = head;
        
        while (runner != null) {
            int cnt = 1;
            int val = runner.val;
            while(runner.next != null && runner.next.val == val) {
                runner = runner.next;
                cnt++;
            }
            ListNode tmpNext = runner.next;
            if (cnt == 1) {
                runner.next = null;
                fakeRunner.next = runner;
                fakeRunner = fakeRunner.next;
            }
            runner = tmpNext;
        }
        
        return fakeHead.next;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        ListNode fakeTail = fakeHead;
        ListNode runner = head;
        
        while (runner != null) {
            ListNode tmpNext = runner.next;
            while (tmpNext != null && tmpNext.val == runner.val) {
                tmpNext = tmpNext.next;
            }
            if (runner.next == tmpNext) {
                fakeTail.next = runner;
                fakeTail = fakeTail.next;
            }
            runner.next = null;
            runner = tmpNext;
        }
        
        return fakeHead.next;
    }
}

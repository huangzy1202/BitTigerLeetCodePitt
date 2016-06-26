package DFS;

public class No_109_Convert_Sorted_List_To_BST {
	public TreeNode sortedListToBST(ListNode head) {
	    if(head == null)
	        return null;
	    ListNode fast = head;
	    ListNode slow = head;
	    ListNode prev =null; 
	    while(fast != null && fast.next != null)
	    {
	        fast = fast.next.next;
	        prev =slow;
	        slow=slow.next;
	    }
	    TreeNode root = new TreeNode(slow.val);
	    if(prev != null)
	        prev.next = null;
	    else
	        head  = null;

	    root.left = sortedListToBST(head);
	    root.right = sortedListToBST(slow.next);
	    return root;
	}
}
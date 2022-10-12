/* Q:Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
			return head;
		if(head.next == null)
			return head;		
		
		int len = getLength(head);
		int rem = k % len;
        
        if(rem == 0) return head;
		
		int travel = len - rem;
		
		ListNode cur = head;
		ListNode first = head;
		
		// finding the last node of the first list
		for(int i = 1; i < travel; i++) {
			cur = cur.next;
		}
		
		// storing the second list
		ListNode temp = cur.next;
		
		// finishing the first list
		cur.next = null;
		
		// traversing to the end of the second list to point it to the 
		// start of the first list
		cur = temp;
		while(true) {
			if(cur.next != null)
				cur = cur.next;
			else 
				break;
		}
		
		cur.next = first;
		
		// setting the head to the start of the second list
		head = temp;
		
		return head;
	}
    
    public int getLength(ListNode head) {
		int len = 0;
		ListNode cur = head;
		while(cur != null) {
			cur = cur.next;
			len++;
		}
		return len;
	}
    }
}
/* package whatever; // don't place package name! 

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:*/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
             ListNode start = head, end = head;
        ListNode startPrev = null, endNext = null;

        //get start and end nodes
        int i = 1;
        while (i < right) {
            if (i < left) {
                startPrev = start;
                start = start.next;
            }

            if (i < right) {
                end = end.next;
            }

            i++;
        }
        
        //save end.next
        endNext = end.next;
        end.next = null;

        //reverse the sub linkedlist
        ListNode reversedHead = reverse(start, end);

        //if sub is the start of the linkedlist
        if (startPrev == null) {
            head = reversedHead;
        } 
        // connect start previous with the new reverse head
        else { 
            startPrev.next = reversedHead;
        }

        //connect the end of the sub linkedlist to the saved end.next
        start.next = endNext;

        //return beginning of the linked list 
        return head;
    }

    // normal reverse linkedlist method 
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode curr = start, prev = null;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }
}


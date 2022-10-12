/* Given a linked list A , reverse the order of all nodes at even positions.



Problem Constraints
1 <= Size of linked list <= 100000



Input Format
First and only argument is the head of the Linked-List A.



Output Format
Return the head of the new linked list.



Example Input
Input 1:

A = 1 -> 2 -> 3 -> 4
Input 2:

A = 1 -> 2 -> 3

*/
ListNode* Solution::solve(ListNode* A) {
ListNode* odd = A;
if(odd== NULL || odd->next==NULL || odd->next->next == NULL)
return A;
ListNode* even=NULL;
while(odd && odd->next){
    ListNode* temp=odd->next;
    odd->next=temp->next;
    temp->next=even;
    even=temp;
    odd=odd->next;
}
odd=A;
while(even){
    ListNode* temp=even->next;
    even->next=odd->next;
    odd->next=even;
    odd=odd->next->next;
    even=temp;
}
return A;
}


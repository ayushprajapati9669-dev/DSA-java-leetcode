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
    public ListNode reverseBetween(ListNode head, int left, int right) {
       // approch---> 1
       /* ListNode temp1=head;
        for(int pos=1;pos<left-1;pos++){
           temp1=temp1.next;
        }
        ListNode prev=null;
        ListNode temp2=temp1.next;
        ListNode curr=temp1.next;
        if(left-1==0){
          curr=temp2=head;   
        }
         
           
         

        for(int i=left;i<=right;i++){
            ListNode Next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
        }
        if(temp1==temp2){
            temp1.next=curr;
            return prev;
        }
        temp1.next=prev;
        temp2.next=curr;
        return head;*/
        
        // approach--->2 
      /*  if(head==null || left==right){
            return head;
        }
        ListNode before=null;
        ListNode temp=head;
        for(int i=1;i<left;i++){
           before=temp;
            temp=temp.next;
        }
        ListNode prev=null;
        ListNode curr=temp;
        for(int i=left;i<=right;i++){
            ListNode Next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
        }
        if(before!=null){
        before.next=prev;
        }else{
            head=prev;
        }
        temp.next=curr;
        return head;*/
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        for(int i=1;i<left;i++){
            prev=prev.next;
        }
        ListNode curr=prev.next;
        for(int i=0;i<right-left;i++){
            ListNode Next=curr.next;
            curr.next=Next.next;
            Next.next=prev.next;
            prev.next=Next;
        }
        return dummy.next;
    }
}
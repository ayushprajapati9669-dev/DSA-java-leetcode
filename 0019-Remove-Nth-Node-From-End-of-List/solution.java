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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    //    if(n==1 && head.next==null){// list contain only one node 
    //     return null;
    //    }
    //    ListNode temp=head;
    //    int length=0;
    //    while(temp!=null){
    //     temp=temp.next;
    //     length++;
    //    }
    //    if(length-n==0){// deleting starting node
    //     return head.next;
    //    }
    //    temp=head;
    //    int idx=1;
    //    while(idx<=length-n-1){
    //     temp=temp.next;
    //     idx++;
    //    }
    //    temp.next=temp.next.next;
    //    return head;

    // approach-2
    ListNode slow=head;
    ListNode fast=head;
   for(int i=1;i<=n;i++){
   fast=fast.next;
   }
   if(fast==null){// deleting starting node
    return head.next;
   }
   while(fast.next!=null){
    slow=slow.next;
    fast=fast.next;
   }
   slow.next=slow.next.next;
   return head;
   //T.C=o(n)
   //S.C=o(1)
}
}
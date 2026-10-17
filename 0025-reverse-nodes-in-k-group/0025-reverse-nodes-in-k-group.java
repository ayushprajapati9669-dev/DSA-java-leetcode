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
    public ListNode reverseKGroup(ListNode head, int k) {
       /* if(k==1){
            return head;
        }
        
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        int groups=length/k;
        if(groups==0){
            return head;
        }
        ListNode heads[]=new ListNode[groups];
        ListNode tails[]=new ListNode[groups];
        ListNode curr=head;
        for(int i=0;i<groups;i++){
           heads[i]=curr;
           ListNode prev=null;
           for(int j=1;j<=k;j++){
            ListNode Next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
           }
           tails[i]=prev;
        }
        for(int i=0;i<groups-1;i++){
            heads[i].next=tails[i+1];
        }
        heads[groups-1].next=curr;
        ListNode newHead=tails[0];
        return newHead;*/
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prevGroup=dummy;
        while(true){
            ListNode kth=prevGroup;
            for(int i=0;i<k && kth!=null;i++){// checking in a group which we want 
                   kth=kth.next;    //to reverse k elements are available or not
            }
            if(kth==null){
                break;
            }
            ListNode nextGroup=kth.next;
            ListNode curr=prevGroup.next;
            ListNode prev=nextGroup;
            while(curr!=nextGroup){
                ListNode Next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=Next;
            }
            // reconnect teh previous group
            ListNode oldGroup=prevGroup.next;
            prevGroup.next=kth;
            prevGroup=oldGroup;
        }
        return dummy.next;
    }
}
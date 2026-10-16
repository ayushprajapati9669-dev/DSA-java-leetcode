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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null ){
        return null;
        }
        if(k==0 || head.next==null){
            return head;
        }
    int length=0;
    ListNode curr=head;
    while(curr!=null){
        curr=curr.next;
        length++;
    }
    k=k%length;
    curr=head;
    for(int i=1;i<length-k;i++){
     curr=curr.next;
    }
    ListNode temp1=curr.next;
    curr.next=null;
    ListNode temp2=temp1;
    while(temp1.next!=null){
    temp1=temp1.next;
    }
    temp1.next=head;
    head=temp2;
    return head;
    }
}
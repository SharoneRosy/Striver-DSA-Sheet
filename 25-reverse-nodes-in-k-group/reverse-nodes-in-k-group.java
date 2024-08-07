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
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        ListNode curr=dummy,nex=dummy,prev=dummy;

        int cnt=0;
        while(curr.next!=null){
            cnt++;
            curr=curr.next;
        }

        while(cnt>=k){
            curr=prev.next;
            nex=curr.next;
            for(int i=1;i<k;i++){
                curr.next=nex.next;
                nex.next=prev.next;
                prev.next=nex;
                nex=curr.next;
            }

            prev=curr;
            cnt-=k;
        }
        return dummy.next;
    }
}
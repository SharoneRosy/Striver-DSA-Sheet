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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int fcp=-1;
        int prevcp=-1;
        int curind=1;
        ListNode curr=head.next;
        ListNode prev=head;
        int [] res=new int[2];
        res[0]=Integer.MAX_VALUE;
        while(curr.next!=null){
            ListNode next=curr.next;
            if((prev.val>curr.val && curr.val<next.val) ||
               (prev.val<curr.val && curr.val>next.val)){
                if(prevcp==-1){
                    prevcp=curind;
                    fcp=curind;
                }else{
                    res[0]=Math.min(res[0],curind-prevcp);
                    prevcp=curind;
                }
                
               }
               curr=curr.next;
               prev=prev.next;
               curind++;
        }
        if(fcp!=-1 && res[0]!=Integer.MAX_VALUE){
            res[1]=prevcp-fcp;
        }else{
            res[0]=-1;
            res[1]=-1;
        }
        
        return res;
    }
}
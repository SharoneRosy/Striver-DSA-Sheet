/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check

    int m=0,n=0;
    ListNode fhead=headA;
    ListNode shead=headB;
    while(fhead!=null){
        m++;
        fhead=fhead.next;
    }
    while(shead!=null){
        n++;
        shead=shead.next;
    }

    ListNode lh=headA,sh=headB;
    if(m<n){
        ListNode temp=lh;
        lh=sh;
        sh=temp;
    }

    int diff=Math.abs(m-n);
    while(diff>0){
        lh=lh.next;
        diff--;
    }

    while(lh!=null && sh!=null){
        if(lh==sh){
            return lh;
        }
        lh=lh.next;
        sh=sh.next;
    }
  return null;
}
}
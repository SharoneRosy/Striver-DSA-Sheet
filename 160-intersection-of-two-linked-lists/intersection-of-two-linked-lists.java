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
        ListNode a=headA;
        ListNode b=headB;
        int cnt=0;
        while(a!=b){
            a=a.next;
            b=b.next;
            if(a==null) {
                a=headB;
                cnt++;
                if(cnt>1){
                    return null;
                }
            }
            if(b==null) b=headA;
        }
        return a;
    }
}
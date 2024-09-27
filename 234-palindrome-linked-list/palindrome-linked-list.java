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
    public ListNode reverseLL(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode newHead=reverseLL(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode newhead=reverseLL(slow.next);
        ListNode first=head;
        ListNode second=newhead;
        while(second!=null){
            if(first.val!=second.val){
                reverseLL(newhead);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        reverseLL(newhead);
        return true;
    }
}
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
    public ListNode  rev(ListNode curr, ListNode prev){
        if(curr==null) return prev;
        ListNode temp=rev(curr.next,curr);
        curr.next=prev;
        return temp;

    }
    public ListNode reverseList(ListNode head) {
            if(head==null || head.next==null) return head;
            return rev(head,null);

    }
}
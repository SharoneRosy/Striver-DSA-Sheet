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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(ListNode list:lists){
            while(list!=null){
                pq.add(list.val);
                list=list.next;
            }
        }
        ListNode newList=new ListNode(-1);
        ListNode head=newList;
        while(!pq.isEmpty()){
            head.next=new ListNode(pq.poll(),null);
            head=head.next;
        }
        return newList.next;
    }
}
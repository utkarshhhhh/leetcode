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
    public ListNode partition(ListNode head, int x) {
        
        ListNode l = new ListNode(0);
        ListNode r = new ListNode(0);
        ListNode lHead = l, rHead = r;
        while( head!=null ){
            ListNode next = head.next;
            if( head.val < x ){
                l.next = head;
                l = l.next;
            }else{
                r.next = head;
                r = r.next;
            }
            head.next = null;
            head = next;
        }
        
        l.next = rHead.next;
        return lHead.next;
    }
}
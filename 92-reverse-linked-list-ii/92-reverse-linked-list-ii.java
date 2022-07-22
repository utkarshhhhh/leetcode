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
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if( left == right ){
            return head;
        }
        
        ListNode x = new ListNode(0), y = null;
        ListNode temp = x, dum = x;
        dum.next = head;
        
        for( int z=1 ; z<=right ; head=head.next, z++ ){
            if( z == left ){
                x = temp;
            }    
            if( z == right ){
                y = head;
            }
            temp = head;
        }
        
        
        ListNode leftNode = x.next;
        x.next = null;
        ListNode rightNode = y.next;
        y.next = null;
        
        ListNode prev = x, next = x, cur = leftNode;
        while( cur!= null ){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        x.next = prev;
        leftNode.next = rightNode;
        return dum.next;
    }
}
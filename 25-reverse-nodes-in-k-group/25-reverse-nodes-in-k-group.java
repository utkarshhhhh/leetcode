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
    
    public ListNode reverse(ListNode head, int k, int s){
        
        if( k > s ) return head;
        
        ListNode cur = head, prev = null;
        
        int temp = k;
        ListNode next = null;
        
        while( cur != null && temp-- > 0 ){
            
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;            
        }
        
        // ListNode newNode = prev.next;
        // prev.next = null;
        
        head.next = reverse( next, k, s-k );
        
        return prev;
    }
    
    private int size(ListNode root){
        
        int s = 0;
        
        while( root!=null ) {
            s++;
            root = root.next;
        }
        
        return s;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int s = size(head);
        
        return reverse(head,k,s);
    }
}
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
        
        ListNode cur = head, prev = null, next = null;
        
        int temp = k;
                
        while( cur != null && temp-- > 0 ){            
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;            
        }
        
        head.next = reverse( next, k, s-k );
        
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int s = 0;        
        for(ListNode t=head ; t!=null ; s++, t = t.next );    
        return reverse(head,k,s);
    }
}
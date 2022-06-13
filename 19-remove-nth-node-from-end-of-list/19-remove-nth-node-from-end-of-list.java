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
    
    private int size(ListNode head){
        
        int ans = 0;
        while(head != null){
            ans++;
            head = head.next;
        }
        return ans;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size = size(head);
        if( size == n ){
            return head.next;
        }
        
        ListNode prev = null, cur = head;
        for(int i=1 ; i<=size-n ; i++ ){
            
            prev = cur;
            cur = cur.next;
            
        }
        prev.next = cur.next;
        
        return head;
    }
}
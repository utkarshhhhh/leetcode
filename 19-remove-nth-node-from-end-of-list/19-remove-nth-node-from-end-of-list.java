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
        
        ListNode dum = new ListNode(0);
        
        ListNode prev = dum, cur = dum;
        prev.next = head;
        
        while( n-->0 ){
            cur = cur.next;
        }
        
        while( cur.next != null ){   
            prev = prev.next;
            cur = cur.next;
        }
        
        prev.next = prev.next.next;
        
        return dum.next;
    }
}
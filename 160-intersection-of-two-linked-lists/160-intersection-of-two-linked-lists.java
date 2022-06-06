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
    
    private int size(ListNode h){
        
        int s = 0;
        
        while( h != null ){
            h = h.next;
            s++;
        }
        return s;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int s1 = size(headA), s2 = size(headB);
        
        while( s1 > s2 ){
            s1--;
            headA = headA.next;
        }

        
        while( s1 < s2 ){
            s2--;
            headB = headB.next;
        }

        
        while( headB != null ){
            if( headA == headB ) return headB;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}
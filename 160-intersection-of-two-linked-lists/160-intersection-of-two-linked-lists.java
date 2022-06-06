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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        HashSet<ListNode> hash = new HashSet<>();
        
        while( headA != null ){
            hash.add(headA);
            headA = headA.next;
        }
        
        
        while( headB != null ){
            if( hash.contains(headB) ) return headB;
            hash.add(headB);
            headB = headB.next;
        }
        
        return null;
    }
}
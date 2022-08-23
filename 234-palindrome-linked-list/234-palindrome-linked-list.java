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
    ListNode st;
    
    public boolean check(ListNode root){
        
        if(root == null){
            return true;
        }
        
        if (!check(root.next)) return false;
        
        if( st.val != root.val ) return false;
        st = st.next;
        return true;        
    }
    
    public boolean isPalindrome(ListNode head) {
        st = head;
        return check(head);
    }
}
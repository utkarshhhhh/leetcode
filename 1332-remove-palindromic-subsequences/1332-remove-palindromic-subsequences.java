class Solution {
    public int removePalindromeSub(String s) {
        
        int n = s.length();
        boolean ans = true; // zero = a, one  = b
        
        int i=0 , j=n-1;
        
        while( i<j ){
            if( s.charAt(i++) != s.charAt(j--) ){
                ans = false;
                break;
            }
        }
        
        return ans ? 1 : 2;
    }
}
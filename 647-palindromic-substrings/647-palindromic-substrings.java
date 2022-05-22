class Solution {
    public int countSubstrings(String s) {
        
        int ans = 0;
        for( int i=0 ; i<s.length() ; i++ ){            
            ans += pallindrome( s, i ,i ) + pallindrome( s, i ,i+1 );            
        }
        return ans;
    }
    
    int pallindrome( String s, int i, int j ){
        
        int ans = 0;
        while( i>=0 && j<s.length() && s.charAt(i) == s.charAt(j) ){
            i--; j++; ans++;
        }
        return ans;
    }
    
}
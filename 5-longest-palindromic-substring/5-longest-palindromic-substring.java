class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];

        int st = 0, len = 1;
        for( int l = n-1 ; l>=0 ; l-- ){
            
            dp[l][l] = true;
            for( int r = l+1 ; r<n ; r++ ){
                
                // if( s.charAt(l) == s.charAt(r) ){
                    dp[l][r] = s.charAt(l) == s.charAt(r) && (l+1 == r || dp[l+1][r-1] );
                // }
                
                if( dp[l][r] && len < r-l + 1 ){
                    st = l;
                    len = r-l + 1;
                }
                
            }
            
        }
        return s.substring( st, st + len );
    }
}
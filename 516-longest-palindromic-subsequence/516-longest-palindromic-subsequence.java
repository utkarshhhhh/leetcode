 class Solution {
    
    public int lcs(String text1, String text2) {
        
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=m ; j++){
                
                if( text1.charAt(i-1) == text2.charAt(j-1) ){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1] );
                }
                
            }
        }
        return dp[n][m];
    }
    
    public int longestPalindromeSubseq(String s) {
        
        // StringBuilder sb = new StringBuilder(s);        
        // return lcs( s, sb.reverse().toString() );
        int n = s.length();
        int[][] dp = new int[n][n]; 
        
        
        // fill from downwords to upwards
        for(int left  = n-1 ; left >= 0 ; left--){
            
            dp[left][left] = 1;
            
            for(int right = left+1 ; right < n  ; right++ ){
                
                if( s.charAt(left) == s.charAt(right) ){
                    dp[left][right] = 2 + dp[left+1][right-1];
                }else{
                    dp[left][right] = Math.max( dp[left+1][right], dp[left][right-1] );
                }

            }            
        }
        return dp[0][n-1];
    }
}
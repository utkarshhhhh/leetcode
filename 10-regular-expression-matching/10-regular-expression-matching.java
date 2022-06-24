class Solution {
    
    private boolean helper(String s, String p, int i, int j, Boolean[][] dp){
        
        if( i == s.length() ){
            return true;
        }
        
        if( j == p.length() ){
            return false;
        }
        
        if( dp[i][j] != null )
            return dp[i][j];
        
        if( p.charAt( j ) == '.' ){
            return dp[i][j] = helper( s,p, i+1, j+1, dp );
        }else if( p.charAt( j ) == '*' ){
            
            if( s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.' )
            return dp[i][j] = helper( s,p, i+1, j, dp ) || helper( s,p, i, j+1, dp );
            
            return helper( s,p, i, j+1 , dp );
        }else if( s.charAt(i) == p.charAt(j) ){
            return dp[i][j] = helper( s,p, i+1, j+1, dp );
        }
        
        return dp[i][j] = false;
    }
    
    public boolean isMatch(String s, String p) {
     
        // return helper( s,p, 0 , 0, new Boolean[s.length()][p.length()] );
        return s.matches(p);
    }
}
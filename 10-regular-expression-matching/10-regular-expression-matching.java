class Solution {
    
    private boolean helper(String s, String p, int i, int j, Boolean[][] dp){
 
        int pl = p.length(), sl = s.length();
        
        if( j == pl ){
            return i==sl;
        }
        
        // if( i==sl) return false;
        
        if( dp[i][j] != null )
            return dp[i][j];
        
        if( j+1<pl && p.charAt( j+1 ) == '*' ){
            
            if(helper( s,p, i, j+2, dp ))
                return dp[i][j] = true;
            
            if( i<sl &&  (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') )
                return dp[i][j] = helper( s,p, i+1, j, dp ) ;
            
            
        }else if( i<sl && (s.charAt(i) == p.charAt(j) || p.charAt( j ) == '.') ){
            return dp[i][j] = helper( s,p, i+1, j+1, dp );
        }
        
        return dp[i][j] = false;
    }
    
    public boolean isMatch(String s, String p) {
     
        return helper( s,p, 0 , 0, new Boolean[s.length()+1][p.length()] );
        // return s.matches(p);
    }
}
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
     
        // return helper( s,p, 0 , 0, new Boolean[s.length()+1][p.length()] );
        // return s.matches(p);
        
        int pl = p.length(), sl = s.length();
        boolean[][] dp = new boolean[sl+1][pl+1];
        
        dp[0][0] = true;
        for(int j=2 ; j<=pl ; j++){
            dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2]; 
 
        }
        
        for( int i=1 ; i<=sl ; i++ ){
            for(int j=1 ; j<=pl ; j++)
           
                if( s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1) == '.' )
                    dp[i][j] = dp[i-1][j-1];
                else if( p.charAt(j-1) == '*') 
                    dp[i][j] = dp[i][j-2] || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]); 
        }
        return dp[sl][pl];
    }
}
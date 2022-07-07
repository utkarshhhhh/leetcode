class Solution {
    
    Boolean[][] dp ;
    
    public boolean helper(String a, String b, String c, int i, int j, int k){
        
        
        if( i > a.length() || j > b.length()){
            return false;
        }
        
        if( i==a.length() && j==b.length() && k == c.length() ){
            return dp[i][j] = true;
        }
        
        if( dp[i][j] != null ){
            return dp[i][j];
        }
        
        if( i<a.length() && a.charAt(i) == c.charAt(k) && helper( a,b,c, i+1, j , k+1 ) ){
            return dp[i][j] = true;
        }
        if( j<b.length() && b.charAt(j) == c.charAt(k) && helper( a,b,c, i, j+1 , k+1 ) ){
            return dp[i][j] = true;
        }
        
        return dp[i][j] = false;
    }
    
    public boolean tab2D(String s1, String s2, String s3) {
        
        
        for(int i=0 ; i<=s1.length() ; i++){
            for(int j=0 ; j<=s2.length() ; j++){
            
                if( i==0 && j==0 ){
                    dp[i][j] = true;
                }else if( i==0 ){
                    dp[i][j] = s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1] ;
                }else if( j==0 ){
                    dp[i][j] = s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j] ;
                }else{
                    
                    dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]) ;                    
                }
                
            }
        }
        return dp[s1.length()][s2.length()];
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if( s1.length() + s2.length() != s3.length() ){
            return false;
        }
        
        dp = new Boolean[s1.length()+1][s2.length()+1];
        
        // return helper(s1,s2,s3,0,0,0);
        return tab2D(s1,s2,s3);
    }
}
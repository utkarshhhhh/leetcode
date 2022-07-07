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
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if( s1.length() + s2.length() != s3.length() ){
            return false;
        }
        
        dp = new Boolean[s1.length()+1][s2.length()+1];
        
        return helper(s1,s2,s3,0,0,0);
        
    }
}
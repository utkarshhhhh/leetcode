class Solution {
    
    public int helper(int sr, int sc ,int dr, int dc, int[][] dp){
        
        if(sr>dr || sc>dc){
            return 0;
        }
        if( dp[sr][sc] != 0 ){
            return dp[sr][sc];
        }
        
        if(sr==dr && sc==dc){
            return dp[sr][sc] = 1;
        }
        
        return dp[sr][sc] = helper(sr+1 , sc , dr, dc, dp) + helper(sr , sc+1 , dr, dc, dp);
        
    }
    
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        return helper(0,0,m-1,n-1,dp);
        
    }
}
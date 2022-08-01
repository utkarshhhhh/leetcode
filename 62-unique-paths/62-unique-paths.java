class Solution {
    
    int[][] dp;
    
    public int helper(int sr, int sc, int dr, int dc){
        
        if( sr>dr || sc>dc ){
            return 0;
        }
        
        if( dp[sr][sc] != 0 ){
            return dp[sr][sc];
        }
        
        if( sr==dr && sc==dc ){
            return dp[sr][sc] = 1;
        }
        
        return dp[sr][sc] = helper(sr+1, sc, dr, dc) + helper(sr, sc+1, dr, dc);    
        
    }
    
    public int uniquePaths(int m, int n) {
        
        dp = new int[m+1][n+1];
        return helper(1,1,m,n);
    }
}
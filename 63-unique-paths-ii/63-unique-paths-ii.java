class Solution {
    
    public int helper(int sr, int sc ,int dr, int dc, int[][] dp, int[][] grid){
        
        if(sr>dr || sc>dc || grid[sr][sc] == 1){
            return 0;
        }
        
        if(sr==dr && sc==dc){
            return dp[sr][sc] = 1;
        }
        
        if( dp[sr][sc] != 0 ){
            return dp[sr][sc];
        }
        return dp[sr][sc] = helper(sr+1 , sc , dr, dc, dp, grid) + helper(sr , sc+1 , dr, dc, dp, grid);
        
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int n = obstacleGrid.length-1 , m = obstacleGrid[0].length-1;
        return helper( 0,0,n,m , new int[n+1][m+1] , obstacleGrid );
        
    }
}
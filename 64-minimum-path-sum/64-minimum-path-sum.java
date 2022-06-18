class Solution {
    public int minPathSum(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 0;    
                }else if(i == 0){
                    dp[i][j] = dp[i][j-1];    
                } else if(j == 0){
                    dp[i][j] = dp[i-1][j];    
                }else
                    dp[i][j] = Math.min( dp[i-1][j], dp[i][j-1] );
                
                dp[i][j] += grid[i][j];    
            }
        }
        return dp[n-1][m-1];
    }
}
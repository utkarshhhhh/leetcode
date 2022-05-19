class Solution {
    
    public int dfs(int[][] mat , int i, int j, int par, int[][] dp){
        
        if( i<0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j] <= par ){
            return 0;
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int[] dir = { 0,-1,0,1,0 };
        
        int max = -1;
        for( int d=0 ; d<4 ; d++ ){
            max = Math.max( max, dfs(mat, i+dir[d] , j+dir[d+1] , mat[i][j] , dp ) );
        }
        
        return dp[i][j] = max+1;
    }
    
    public int max(int[][] dp){
        int ans = -1;
        for(int[] i : dp){
            for(int j : i){
                ans = Math.max(ans, j);
            }
        }
        return ans;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length , m = matrix[0].length;
        int[][] dp = new int[n][m]; 
        
        for(int [] i : dp)
            Arrays.fill( i, -1);
        
        for(int i=0; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                dp[i][j] = dfs(matrix, i,j,-1,dp);
            }
        }
        
        return max(dp);
    }
}
class Solution {
    
    int mod = (int)1e9+7;
    
    int[][][] dp = new int[51][51][51];
    
    public int helper(int m, int n, int maxMove, int startRow, int startColumn) {
        
        if( startRow<0 || startRow==m || startColumn<0 || startColumn==n ){
         return 1;   
        }
        
        if( maxMove == 0 ){
            return 0;
        }
        
        if( dp[startRow][startColumn][maxMove] != -1 ){
            return dp[startRow][startColumn][maxMove];
        }
        
        int ans = (( helper(m,n,maxMove-1,startRow+1,startColumn) + helper(m,n,maxMove-1,startRow-1,startColumn) )%mod + ( helper(m,n,maxMove-1,startRow,startColumn+1) + helper(m,n,maxMove-1,startRow,startColumn-1) )%mod ) % mod;
        
        return dp[startRow][startColumn][maxMove] = ans;
        
    }
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        for(int[][] dpp : dp){
            for(int[] dppp : dpp){
                Arrays.fill(dppp, -1);
            }
        }
        
        return helper(m,n,maxMove,startRow,startColumn);
        
    }
}
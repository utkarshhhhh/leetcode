class Solution {
    
    public int helper( int[] arr, int left, int right, int[][] dp ){
        
        if( left + 1 == right ){
            return 0;
        }
        
        if( dp[left][right] != -1 )
            return dp[left][right];
        
        int min = Integer.MAX_VALUE;
        for(int i=left+1 ; i< right ; i++  ){
            
            int temp = helper( arr, left, i, dp ) + helper( arr, i, right, dp ) + arr[left]*arr[i]*arr[right]; 
            min = Math.min( min, temp );
            
        }
        
        return dp[left][right] = min;
    }
    
    public int minScoreTriangulation(int[] values) {
        
        int n = values.length;
        int[][] dp = new int[n][n];
        
        for(int[] f : dp)
            Arrays.fill(f, -1);
        
        return helper( values, 0, n-1, dp );
    }
}
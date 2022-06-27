class Solution {
    public int minCost(int n, int[] cuts) {
        
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] cut = new int[m+2];
        for(int i=1 ; i<=m ; i++){
            cut[i] = cuts[i-1];
        }
        cut[m+1] = n;
        
        int[][] dp = new int[m+2][m+2];
        
        return helper( cut, 0, m+1, dp );
    }
    
    public int helper(int[] cut, int i, int j, int[][] dp){
        
        if( i+1>=j ){
            return 0;
        }
        if( dp[i][j] != 0 ){
            return dp[i][j];
        }
        
        if( i+2 == j ){
            return dp[i][j] = cut[j]-cut[i];
        }
        
        
        int min = Integer.MAX_VALUE;
        for(int k=i+1 ; k<j ; k++ ){
            min = Math.min( helper(cut, i, k, dp) + helper(cut, k, j, dp), min );
        }
        
        return dp[i][j] = min + cut[j] - cut[i]  ;
    }
    
}
class Solution {
    public int minDistance(String word1, String word2) {
 
        int n = word1.length() , m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0 ; i<=n ; i++){
            for(int j=0 ; j<=m ; j++){
                
                if( i==0 ){
                    dp[i][j] = j;
                }else if( j==0 ){
                    dp[i][j] = i;
                }else if( word1.charAt(i-1) == word2.charAt(j-1) ){
                    dp[i][j] = dp[i-1][j-1];
                }else{                    
                    int insert = dp[i][j-1];
                    int remove = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    
                    dp[i][j] = 1 + Math.min( insert, Math.min( remove, replace ) );
                }        
            }
        }
        
        return dp[n][m];
    }
}
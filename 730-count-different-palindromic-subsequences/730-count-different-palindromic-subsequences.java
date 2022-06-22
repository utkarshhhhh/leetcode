class Solution {
    
    int mod = (int)1e9+7;
    
    public int countPalindromicSubsequences(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for(int left = n-1 ; left>=0 ; left--){
            
            dp[left][left] = 1;
            for(int right = left+1 ; right<n ; right++){
                
                if( s.charAt(left) == s.charAt(right) ){
                    
                    int i = left+1, j = right-1; 
                    
                    while( i<=j && s.charAt(i) != s.charAt(right) ){
                        i++;
                    }
                    
                    while( i<=j && s.charAt(j) != s.charAt(right) ){
                        j--;
                    }
                    
                    if( i > j ){
                        dp[left][right] = 2*dp[left+1][right-1] + 2;
                    }else if( i==j ){
                        dp[left][right] = 2*dp[left+1][right-1] + 1;
                    }else{
                        dp[left][right] = 2*dp[left+1][right-1] - dp[i+1][j-1];
                    }
                    
                }else{
                    dp[left][right] = dp[left+1][right] + dp[left][right-1] - dp[left+1][right-1];
                }
                dp[left][right] = dp[left][right] < 0 ? dp[left][right] + 1000000007 : dp[left][right] % 1000000007;
            }
        }
        return dp[0][n-1];
    }
}
class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int[][] dp = new int[2][k+1];
        
        Arrays.fill( dp[1], Integer.MIN_VALUE );
        
        for(int i=0 ; i<prices.length ; i++){
            
            int price = prices[i];
            
            for(int j = k ; j>0 ; j-- ){
                dp[0][j] = Math.max( dp[0][j], dp[1][j] + price);
                dp[1][j] = Math.max( dp[1][j], dp[0][j-1] - price);
            }
            
        }
        
        return dp[0][k];
    }
}
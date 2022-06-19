class Solution {
    public int maxProfit(int[] prices) {
        
        int dp0 = 0 , dp1 = Integer.MIN_VALUE;
        
        for(int x : prices){
            
            int prevProfit = dp0;
            dp0 = Math.max( dp0, dp1 + x );
            dp1 = Math.max( dp1, prevProfit - x );
            
        }
        return dp0;
    }
}
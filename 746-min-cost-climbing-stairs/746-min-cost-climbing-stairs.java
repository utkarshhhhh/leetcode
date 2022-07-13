class Solution {
    
    Integer[] dp = new Integer[1001];
    public int helper(int[] cost, int idx){
        
        if( idx >= cost.length ) return 0;
        
        if(dp[idx] != null) return dp[idx];
        
        return dp[idx] = Math.min( helper( cost, idx+1 ) , helper( cost, idx+2 ) ) +  cost[idx] ;
    }
    
    public int minCostClimbingStairs(int[] cost) {
        
        return Math.min( helper( cost, 0 ) , helper( cost, 1 ) );        
    }
}
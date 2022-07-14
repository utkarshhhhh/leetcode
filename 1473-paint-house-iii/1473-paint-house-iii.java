class Solution {
    
    Integer[][][] dp = new Integer[101][21][101];
    int m,n;
    int maxx = (int)1e8;
    public int helper(int[] houses, int[][] cost, int idx, int prevCol, int tar ){
        
        if( idx == houses.length || tar < 0 ) return tar==0 ? 0 : maxx;
        
        if(dp[idx][prevCol][tar] != null){
            return dp[idx][prevCol][tar];
        }
        
        if( houses[idx] != 0 ){
            return dp[idx][prevCol][tar] = helper( houses, cost, idx+1, houses[idx], tar - (houses[idx]==prevCol ? 0 : 1) );
        }
        
        int min = maxx;
        for(int i = 1 ; i<=cost[idx].length ; i++){ // i== color
            int cur = helper( houses, cost, idx+1, i , tar - (i==prevCol ? 0 : 1) );
            min = Math.min( min, cur + cost[idx][i-1] );
        }
        return dp[idx][prevCol][tar] = min;
    }
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
    
        this.m = m;
        this.n = n;
        
        int ans = helper( houses, cost, 0, 0, target );
        return ans>=maxx ? -1 : ans;
        
    }
}
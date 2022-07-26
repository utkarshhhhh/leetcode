class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
     
        int[] dp = new int[n];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;
        
        for(int i=1 ; i<=k+1 ; i++){ // src + k stops -> total k+1 stops
            
            int[] dp1 = dp.clone();
            for(int[] f : flights){
                
                int u = f[0], v = f[1], uv = f[2];
                
                if( dp[u] != Integer.MAX_VALUE ){
                    dp1[v] = Math.min( dp1[v], dp[u] + uv );
                }                
            }            
            dp = dp1;
        }
        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }
    
}
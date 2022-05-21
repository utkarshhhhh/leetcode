class Solution {
    
    public int helper( int[] coins, int am, int idx ){
        
        if( am == 0 ){
            return 0;
        }
        if(am < 0){
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        
        for( int i=idx ; i >= 0 ; i-- ){
            
            int cur = helper( coins , am-coins[i] , i );        
            min = Math.min(min, cur);
        }
        
        return min==Integer.MAX_VALUE?Integer.MAX_VALUE:min+1;
    }
    
    public int coinChange(int[] coins, int amount) {
        
        // Arrays.sort(coins);
        // int ans = helper( coins, amount , coins.length-1 );
     
        int n = coins.length;
        int[] dp = new int[amount+1];
        
        for(int i=1 ; i<=amount ; i++){
            int min = Integer.MAX_VALUE;
            
            for(int coin : coins){
                if( i-coin >= 0 && dp[i-coin] != -1){                        
                        min = Math.min(dp[i-coin] ,min);                          
                }
                
            }
            dp[i] =  min==Integer.MAX_VALUE?-1 : min+1;
        }
        return  dp[amount];        
    }
}
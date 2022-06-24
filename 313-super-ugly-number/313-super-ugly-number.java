class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        long[] dp = new long[n+1];
        // dp[1] = Math.min( a, Math.min( b, c ) );
        dp[1] = 1;
        
        int[] ptr = new int[primes.length];
        Arrays.fill(ptr, 1);
        
        for(int i=2 ; i<=n ; i++){
            
            long min = Integer.MAX_VALUE;
            
            for(int j = 0 ; j<primes.length ; j++ ){
                min = Math.min( primes[j]*dp[ ptr[j] ], min );                
            }
            
            dp[i] = min;
            
            for(int j = 0 ; j<primes.length ; j++ ){            
                if( min == primes[j]*dp[ ptr[j] ] ){
                    ptr[j]++;       
                }
            }
            
        }
        
        return (int)dp[n];  
        
    }
}
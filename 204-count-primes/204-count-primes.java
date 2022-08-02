class Solution {
    public int countPrimes(int n) {
        
        if( n<=1 ) return 0;
        
        boolean[] primes = new boolean[n];
        int ans = 0;
        
        primes[0] = primes[1] = false;
        
        for(int i=2 ; i<n ; i++){
            
            if( !primes[i] ){
                ans++;
                // System.out.print(i +" ");
                for(int mul = 2 ; mul*i < n ; mul++){                
                    primes[ i*mul ] = true;                    
                }                
            }
        }
        
        return ans;
    }
}
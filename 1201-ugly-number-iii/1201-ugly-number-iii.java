class Solution {
    
    private long gcd(long a, long b){
        
        if(a == 0)
            return b;        
        return gcd( b%a, a );
    }
    
    private long lcm( long a, long b ){
        return (a*b)/gcd(a,b);
    }
    
    private int count( int n , int a, int b, int c ){
        
        long ans = n/a + n/b + n/c;
        
        ans -= ( n/lcm(a,b) + n/lcm(c,b) + n/lcm(a,c) );
        
        ans += n/lcm(a, lcm(b,c) );
        
        return (int)ans;
    }
    
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        int lo = 1 , hi = (int)2e9, mid;
         
        int ans = 0;
        while( lo <= hi ){
            
            mid = lo + (hi-lo)/2;
            
            if( count(mid, a, b, c) >= n ){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
            
        }
        return ans;
    }
}
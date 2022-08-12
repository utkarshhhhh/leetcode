class Solution {
    
    double pow( double x, int n ){
        
        if( n==0 ) return 1.0;
        
        double ans = pow( x, n/2 );
        
        return n%2 == 0 ? ans*ans : ans*ans*x ;
    }
    
    public double myPow(double x, int n) {
        
        
        double ans = pow(x, Math.abs(n) );
        
        return n>=0 ? ans : 1/ans;
        
    }
}
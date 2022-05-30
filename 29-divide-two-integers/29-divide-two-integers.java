class Solution {
    public int divide(int dividend, int divisor) {
        
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        
        int sign = (dividend>0 ? 1 : -1) * (divisor>0 ? 1 : -1);
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int q = 0;
        int sum = 0;
        for(int i=31 ; i>=0 ; i--){
            
            if( (dividend>>>i) - divisor >= 0 ){
                q |= 1<<i;
                dividend -= (divisor<<i);
            }
            
        }
        return sign*q;
    }
}
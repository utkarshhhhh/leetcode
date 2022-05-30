class Solution {
    public int divide(int dividend, int divisor) {
        
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        
   
        
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);

        int q = 0;
        int sum = 0;
        for(int i=31 ; i>=0 ; i--){
            
            if( (a>>>i) - b >= 0 ){
                q |= 1<<i;
                a -= (b<<i);
            }
            
        }
        return (dividend > 0) == (divisor > 0) ? q : -q;
        
        //   if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        // int a = Math.abs(A), b = Math.abs(B), res = 0;
        // for (int x = 31; x >= 0; x--)
        //     if ((a >>> x) - b >= 0) {
        //         res += 1 << x;
        //         a -= b << x;
        //     }
        // return (A > 0) == (B > 0) ? res : -res;
    }
}
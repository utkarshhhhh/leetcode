class Solution {
    public boolean isPowerOfFour(int n) {
        
        
        if(n<=0 || (n&(n-1)) != 0 )
            return false;
        
        // int i = 0;
        // while( n!=0 ){
        //     i++;
        //     n >>= 1;
        // }
        
        int mask = 0b01010101010101010101010101010101;
        
        // return i%2==1;
        return (n&mask) != 0 ;
    }
}
class Solution {
    
    public int findTheWinner(int n, int k) {
        
        if( n==1 ) return 1;        
        int nm1 = findTheWinner(n-1, k);    
        // subtract 1 for 0 based indexing , add for 1 based indexing
        return  (nm1+k-1)%n +1 ;        
    }
}
class Solution {
    
//     private int josepheus(int n, int k){
        
//     }
    
    public int findTheWinner(int n, int k) {
        
        if( n==1 ) return 1;
        
        int nm1 = findTheWinner(n-1, k);
    
        return  (nm1+k-1)%n+1 ;
    }
}
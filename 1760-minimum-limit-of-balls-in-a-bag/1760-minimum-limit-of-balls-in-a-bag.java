class Solution {
    
    boolean check(int[] arr, long mid, int k){
         
         int count = 0;
         long sum = 0;
         for( int x : arr ){
             
             long rem = x - mid;
             if( rem  > 0 ){
                 count += ( rem + mid -1 )/mid;
             }
             
             
             if( count > k ) return false;
         }
         return count <= k;
     }
     
    
    public int minimumSize(int[] nums, int maxOperations) {
     
        long lo = 1, hi = 0;
        
        for(int x : nums){
            // lo = Math.max(lo, x);
            hi = Math.max(hi, x);
        }
        
        while( lo < hi ){
            
            long mid = (lo+hi)>>1;
            
            if( check( nums, mid, maxOperations ) ){
                hi = mid;
            }else{
                lo = mid+1;
            }
            
        }
        return (int)lo;
        
    }
}
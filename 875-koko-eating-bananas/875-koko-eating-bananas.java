class Solution {
    
    boolean check(int[] arr, int cap, int max){
        
        int count = 0;
        
        for( int x : arr ){
            count += ( x + cap - 1 )/cap;
        }
        return count <= max;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        
        int lo = 1, hi = 0;
        
        for(int x : piles){
            hi = Math.max(x, hi);
        }
        
        while( lo < hi ){
            
            int mid = (lo+hi)>>1;
            
            if( check(piles, mid, h) ){
                hi = mid;
            }else{
                lo = mid+1;
            }
            
        }
        return lo;
    }
}
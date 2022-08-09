class Solution {
    
    public boolean check(int[] arr, int cur, int tar){
        
        int count = 1;
        int sum = 0;
        for(int x : arr){
            
            if( sum + x > cur ){
                count++;
                sum = x;
            }else{
                sum += x;
            }
            
            if( count > tar ) return false;
        }
        
        return count <= tar;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        
        int lo = 0, hi = 0;
        
        for(int x: weights){
            lo = Math.max(lo, x);
            hi += x;
        }
        
        while( lo < hi ){
            
            int mid = ( hi + lo )/2;
            
            if( check( weights, mid, days ) ){
                hi = mid;
            }else{                
                lo = mid + 1;
            }
            
        }
        
        return lo;
    }
}
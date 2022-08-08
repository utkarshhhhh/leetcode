class Solution {
    
    int check(int[] arr, int x){
        
        int sum = 0, count = 1;
        
        for(int i : arr){
            
            if( sum + i > x  ){
                count++;
                sum = i;
            }else{
                sum += i;
            }
            
        }
        return count;        
    }
    
    public int splitArray(int[] nums, int m) {
        
        int lo = 0, hi = 0;
        
        for(int x : nums){
            lo = Math.max(lo, x);
            hi += x;
        }
        
        while( lo < hi ){
            
            int mid = lo + (hi-lo)/2;
            
            if( check(nums, mid) > m ){
                lo = mid+1;
            }else{
                hi = mid;
            }
            
        }
        return lo;
    }
}
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        Arrays.sort(nums);
        
        int lo=1 , hi = nums[ nums.length-1 ], ans = 0;
        
        while( lo < hi ){
            
            int mid = (lo+hi)/2;
            int sum = 0;
            for(int x : nums){
                sum += (x+mid-1)/mid;
            }
            
            if( sum > threshold  ){                
                lo = mid+1;
            }else{
                hi = mid;
            }
            
        }
        
        return lo;
    }
}
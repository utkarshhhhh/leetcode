class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int st=-1, end=-1 ;
        int prevHigh = nums.length - 1, prevLow = 0;
        
        for(int i=0 ; i< nums.length ; i++){
            
            if( nums[i] < nums[prevLow] ){
                end = i;
            }else{
                prevLow = i;
            }
            
        }
        
        for(int i=nums.length-1 ; i>=0 ; i--){
            
            if( nums[i] > nums[prevHigh] ){
                st = i;
            }else{
                prevHigh = i;
            }
            
        }
        
        
        
        return ( st >=0 && end >=0 ) ? end-st+1 : 0;
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        
        int prev = nums[0], count = 1;
        
        for(int i=1 ; i<nums.length ; i++){
            
            if( prev == nums[i] ){
                count++;
            }else if( count == 0 ){
                count = 1;
                prev = nums[i];
            }else{
                count--;
            }
            
        }
        return prev;
    }
}
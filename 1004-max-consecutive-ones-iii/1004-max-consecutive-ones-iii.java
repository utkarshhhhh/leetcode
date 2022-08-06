class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length, z = 0, o = 0, max = 0 ;
        for(int i=0, j=0 ; i<n ; i++){
            
            if( nums[i] == 0 ) z++;
            else o++;
            
            while( z > k ){
                
                if( nums[j] == 0 ) z--;
                else o--;
                j++;
            }
            
            max = Math.max(max, z+o);
            
        }
        
        return max;
    }
}
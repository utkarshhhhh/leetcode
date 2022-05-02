class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int i=0 , j = nums.length;
        int st = -1;
        while( i<j ){
            
            if( nums[i]%2 == 0 ){
                  
                int temp = nums[i];
                nums[i] = nums[++st];
                nums[st] = temp;
            }
                i++;
            
            
        }
     return nums;   
    }
}
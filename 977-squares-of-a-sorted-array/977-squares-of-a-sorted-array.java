class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int i=0, j = nums.length-1;
        int idx = j;
        int[] ans = new int[j+1];
        
        while( i<=j ){
            
            if( Math.abs(nums[i]) > Math.abs(nums[j]) ){
                ans[idx--] = nums[i]*nums[i++];
            }else{
                ans[idx--] = nums[j]*nums[j--];
            }
            
        }
        return ans;
    }
}
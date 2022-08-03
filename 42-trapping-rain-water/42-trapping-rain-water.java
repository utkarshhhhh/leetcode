class Solution {
    public int trap(int[] height) {
        
        //app1 : 2 arr max left right
        
        int i=0 , j = height.length-1;
        int left = 0, right = 0, ans = 0;
        
        while(i<=j){
            
            left = Math.max(left, height[i]);    
            right = Math.max(right, height[j]);    
            
            if( left < right ){
                ans += left-height[i];
                i++;
            }else{
                ans += right-height[j];
                j--;
            }
            
        }
        
        return ans;
    }
}
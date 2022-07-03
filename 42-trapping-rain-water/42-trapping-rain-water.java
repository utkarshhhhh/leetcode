class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
//         int[] left = new int[n], right = new int[n];
        
//         left[0] = height[0];
//         right[n-1] = height[n-1];
        
//         for(int i=1 ; i<n; i++){
//             left[i] = Math.max( left[i-1], height[i] );
//         }
        
//         for(int i=n-2 ; i>=0; i--){
//             right[i] = Math.max( right[i+1], height[i] );
//         }
        
        int ans = 0;
        
//         for( int i=1 ; i<n-1 ; i++ ){        
//             ans += Math.min( left[i], right[i] ) - height[i];            
//         }
        
        int left = height[0], right = height[n-1];
        
        int i = 0, j = n-1;
        while( i < j ){
            
            left = Math.max(left, height[i]);
            right = Math.max(right, height[j]);
            
            if( left <= right ){
                
                ans += left - height[i];
                i++;
            
            }else{
                
                ans += right - height[j];
                j--;
            
            }            
        }
        
        
        return ans;
    }
}
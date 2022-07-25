class Solution {
    
    int low(int[] arr, int t){
        
        int i=0 , j = arr.length-1,m;
        
        int l = -1;
        while( i<=j ){
            
            m = (i+j)/2;
            if( arr[m] == t ){
                l = m;
                j = m-1;
            }else if( arr[m] < t ){
                i = m+1;
            }else{
                j=m-1;
            }
        }
        return l;
    }
    
    int high(int[] arr, int t){
        
        int i=0 , j = arr.length-1,m;
        
        int h = -1;
        while( i<=j ){
            
            m = (i+j)/2;
            if( arr[m] == t ){
                h = m;
                i = m+1;
            }else if( arr[m] < t ){
                i = m+1;
            }else{
                j=m-1;
            }
        }
        return h;
    }
    
    public int[] searchRange(int[] nums, int target) {
    
        int[] ans = {-1, -1};
        
        // if( nums.length == 0 ) return ans;
        
        ans[0] = low( nums, target );
        ans[1] = high( nums, target );
        
        return ans;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();
        
        next[n-1] = n;
        st.push( n-1 );
        
        for(int i=n-2 ; i>=0 ; i--){
            
            while( st.size() > 0 && nums[i] > nums[st.peek()] ){
                st.pop();
            }
            
            next[i] = st.size()==0 ? n : st.peek();
            
            st.push( i );
        }
        
        int[] ans = new int[ n-k+1 ];
        int j=0;
        // 12345
        for( int i=0 ; i<n-k+1 ; i++ ){
            
            if( j<i ) j = i;
            
            while( next[j] <= i+k-1 ){
                j = next[j];
            }
            
            ans[i] = nums[j];
        }
        
        return ans;
    }
}
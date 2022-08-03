class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
     
        return Math.max( helper(nums, firstLen, secondLen), helper(nums, secondLen, firstLen) );
    }
    
    public int helper(int[] arr, int l, int r){
        
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        int sum = 0, prev = 0;
        for(int i=0 ; i<n ; i++){
            sum += arr[i];
            if( i==l-1 ) {
                left[i] = sum; 
            }else if( i>=l ){
                sum -= arr[prev++];
                left[i] = Math.max(sum, left[i-1]); 
            }
        }
        
        prev = n-1;
        sum = 0;
        
        for(int i=n-1 ; i>=0 ; i--){
            sum += arr[i];
            if( i==n-r ) {
                right[i] = sum;                 
            }else if( i<n-r ){
                sum -= arr[prev--];
                right[i] = Math.max(sum, right[i+1]); 
            }
        }
        /*
        0123456789
          x   x
        */
        int max = 0;
        
        for( int i=l-1 ; i<n-r ; i++ ){
            max = Math.max( max, left[i] + right[i+1] );
        }
        return max;
    }
}
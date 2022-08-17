class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        
        int lo = matrix[0][0], hi = matrix[n-1][n-1];
        
        while( lo < hi ){
            
            int mid = lo + (hi-lo)/2;
            
            int count = 0;
            // count
            int j = n-1;
            
            for(int i=0 ; i<n ; i++){
                
                
                
                while( j>=0 && matrix[i][j] > mid ){
                    j--;
                }
                /*1  5  9
                  10 11 13
                  12 13 15
                */
                count += j+1;
            }
            
            // count end
            if( count < k ){
                lo = mid+1;
            }else{
                hi = mid;
            }
            
        }
        return lo;
    }
}
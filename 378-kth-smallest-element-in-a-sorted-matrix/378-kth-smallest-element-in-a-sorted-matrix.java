class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)->{
            return a[2] - b[2];
        } );
        
        int n = matrix.length , m = matrix[0].length;
        for(int i=0 ; i<n ; i++){
            pq.offer( new int[]{ i,0,matrix[i][0] } );
        }
        
        for(int i=0 ; i<k-1 ; i++){
            
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], val = cur[2];
            if( c+1 < n ){
                pq.offer( new int[]{ r, c+1, matrix[r][c+1] } );
            }            
        }
        
        return pq.poll()[2];
    }
}
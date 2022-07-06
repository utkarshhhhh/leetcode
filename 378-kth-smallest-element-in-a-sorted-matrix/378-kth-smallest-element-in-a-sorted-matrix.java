class Solution {
    
    class pair{
        int r , c, num;
        pair(int x, int y, int n){
            r = x;
            c = y;
            num = n;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
     
        PriorityQueue<pair> pq = new PriorityQueue<>( (a,b)-> a.num - b.num );
        
        int n = matrix.length , m = matrix[0].length;
        for(int i=0 ; i<n ; i++){
            pq.offer( new pair( i,0,matrix[i][0] ) );
        }
        
        int count = 0;
        while( count < k-1 ){            
            pair cur = pq.poll();            
            if( cur.c +1 < m ) pq.offer( new pair( cur.r, cur.c+1, matrix[ cur.r ][ cur.c+1 ] ) );            
            count++;
        }
        
        return pq.peek().num;
    }
}
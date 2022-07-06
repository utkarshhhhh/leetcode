class Solution {
    
    class pair{
        int r , c, i;
        pair(int x, int y){
            r = x;
            c = y;
        }
    }
    
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        PriorityQueue<pair> pq = new PriorityQueue<>( (a,b)-> arr[a.r]*arr[b.c] - arr[b.r]*arr[a.c] );       
        
        int n = arr.length;
        for(int i=0 ; i<n-1 ; i++){
            pq.offer( new pair( i, n-1 ) );
        }
        
        int count = 1;
        
        while( count < k ){

            pair cur = pq.poll();
            if( cur.c-1 < n && arr[cur.c] != arr[cur.c-1]){
                pq.offer( new pair( cur.r, cur.c-1 ) );
            }
            
            count++;
        }

        return new int[]{ arr[pq.peek().r], arr[pq.peek().c] };
    }
}
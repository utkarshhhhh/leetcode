class Solution {
    
    class pair{
        int x, y, z;
        
        pair(int i, int j){
            x = i; y = j;
            z = x*x + y*y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<pair> q = new PriorityQueue<>( (a,b)-> b.z - a.z );
        
        for( int[] point : points ){
            
            if( q.size() < k ){
                q.add( new pair( point[0], point[1] ) );
            }else{
                
                pair cur = new pair( point[0], point[1] );
                
                if( cur.z < q.peek().z ){
                    q.poll();
                    q.add(cur);
                }
            }            
        }
        
        int[][] ans = new int[k][2];
        
        for(int i=k-1 ; i>=0 ; i--){
            pair p = q.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }
}
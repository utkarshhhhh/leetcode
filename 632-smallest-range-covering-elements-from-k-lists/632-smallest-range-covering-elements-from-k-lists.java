class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int n = nums.size();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)-> a[2] - b[2] );
        int a = 1000000, b = -1000000;
        for(int i=0 ; i<n ; i++){
            pq.add( new int[]{ i,0,nums.get(i).get(0) } );
            a = Math.min( a, nums.get(i).get(0) );
            b = Math.max( b, nums.get(i).get(0) );
        }
        
        int c = a, d = b;
        
        while( pq.size() > 1 ){
            
            int[] cur = pq.poll();
            
            c = pq.peek()[2];
            
            if( cur[1]+1 < nums.get(cur[0]).size() ){
                cur[1]++;
                cur[2] = nums.get( cur[0] ).get( cur[1] );
                
                c = Math.min( c, nums.get( cur[0] ).get( cur[1] ) );
                d = Math.max( d, nums.get( cur[0] ).get( cur[1] ) );

                if( b-a > d-c ){
                    a = c;
                    b = d;
                }
                
                pq.add(cur);
            }else{
                break;
            }
        }
        return new int[]{ a,b };
    }
}
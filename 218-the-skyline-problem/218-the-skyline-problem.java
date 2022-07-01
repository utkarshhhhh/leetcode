class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<int[]> points = new ArrayList<>();
        
        for(int i=0 ; i<buildings.length ; i++){
            
            points.add( new int[]{ buildings[i][0], -buildings[i][2] } );
            points.add( new int[]{ buildings[i][1], buildings[i][2] } );
             
        }
        
        Collections.sort( points, (a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0] );
        
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b)-> b-a );
        pq.add(0);
        int curH = 0;
        
        
        for(int[] h : points){
            
            if( h[1] > 0 ){
                pq.remove( h[1] );
            }else{
                pq.offer( -h[1] );
            }
            
            int cur = pq.peek();
            if( curH != cur ){
                
                List<Integer> c = new ArrayList<>();
                c.add( h[0] ); 
                c.add( cur );
                ans.add(c);
                curH = cur;
            }            
        }
        return ans;
    }
}
class Solution {
    
    private class pair{
        int i,j;
        pair(int x , int y){
            i = x; j = y;
        }
    }
    
    private int count(int[][] grid ,Queue<pair> q){
        
        int fresh = 0;
        int n = grid.length, m = grid[0].length;
        for(int r=0 ; r<n ; r++){
            for(int c=0 ; c<m ; c++){
                if( grid[r][c] == 1 ){
                    fresh++;
                }else if( grid[r][c] == 2 ){
                    q.add( new pair(r,c) );
                }
            }
        }
        return fresh;
    }
    
    private int[] dir = { 0, 1, 0, -1, 0 };
    
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length , m = grid[0].length;
        int time = 0;
        
        Queue<pair> q =new LinkedList(); // places of rottenO.

        int fresh = count( grid, q );
        
        if(fresh == 0) return 0;
        
        while( !q.isEmpty() ){
            
            int size = q.size();
            
            for(int i=0; i<size ; i++){
            
                pair cur = q.poll();
                int x = cur.i, y = cur.j;

                // if( grid[x][y] != 2 ) continue;

                
                for( int d=0 ; d<4 ; d++ ){
                    
                    int r = x + dir[d], c = y + dir[d+1];
                    if( r>=0 && c>=0 && r<n && c<m && grid[r][c] == 1 ){
                        
                        grid[r][c] = 2;
                        fresh--;
                        
                        if(fresh==0) return time+1;
                        
                        q.add( new pair(r,c) );
                    }                    
                }
            }
            
            time++;
        }
        return fresh==0?time : -1;
    }
}
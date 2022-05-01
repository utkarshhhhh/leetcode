class Solution {
    
    private class pair{
        int i,j;
        pair(int x , int y){
            i = x; j = y;
        }
    }
    
    private int count(int[][] grid ,Queue<pair> q){
        
        int n = grid.length , m = grid[0].length;
        int c = 0;
        for(int i=0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                
                if( grid[i][j] == 2 ){
                    q.add( new pair(i,j) );
                }else if( grid[i][j] == 1 ){
                    c++;
                }
            }
        }
        return c;
    }
    
    private int[] dir = { 0, 1, 0, -1, 0 };
    
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length , m = grid[0].length;
        int time = 0;
        Queue<pair> q = new LinkedList<>();
        int fresh = count(grid , q);
        
        if( fresh == 0 )
            return time;          
        while( !q.isEmpty() ){
            
            int size = q.size();
            
            while( size-- > 0 ){
                
                pair rem = q.remove();
                
                // if (grid[rem.i][rem.j] == 1 ){
                //     grid[rem.i][rem.j] = 2;
                //     fresh--;
                // }
                // if( fresh == 0 ){
                //     return time;
                // }
                
                for(int i=0 ; i<4 ; i++ ){
                    int r = rem.i + dir[i];
                    int c = rem.j + dir[i+1];
                    
                    if( r>=0 && r<n && c>=0 && c<m && grid[r][c] == 1 ){
                        q.add( new pair(r,c) ); 
                        
                       
                            grid[r][c] = 2;
                            fresh--;                        
                        if( fresh == 0 )
                            return time+1;                                         
                    }
                }                
            }
            time++;
        }
        return fresh!=0 ? -1 : time;
    }
}
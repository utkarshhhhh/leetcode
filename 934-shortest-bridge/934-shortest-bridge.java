class Solution {
    
    class Pair{
        int x, y;    
        Pair( int i, int j){
            x = i;  y = j;
        }        
    }
    
    int[] dir = { 0, 1, 0, -1, 0 };
    
    public void dfs(int[][] grid, int i, int j, Queue<Pair> q){
        
        int n = grid.length;
        if( i<0 || i>=n || j<0 || j>=n || grid[i][j]!=1){
            return ;
        }
        grid[i][j] = 3;
        q.add( new Pair(i,j) );
        for(int d=0 ; d<4 ; d++ ){
            dfs( grid, i+dir[d] , j + dir[d+1], q );
        }        
    }
    
    public void bfs( int[][] grid, int i, int j, Queue<Pair> q ){
        
        int n = grid.length;
        if( i<0 || i>=n || j<0 || j>=n || grid[i][j]==2){
            return ;
        }
        q.add( new Pair( i,j ) );
    }
    
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        boolean flag = false;
        
        // init one island
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if( grid[i][j] == 1 ){
                    dfs(grid, i,j, q);
                    flag = true; break;
                }
            }
            if( flag ) break;
        }
        // init complete
        
        int ans = -1;
        
        while( q.size() > 0 ){
            
            ans++;
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                
                Pair cur = q.poll();
                int r = cur.x, c = cur.y;
                
                if( grid[r][c] == 1 ) return ans-1;
                if( grid[r][c] == 2 ) continue;
                
                grid[r][c] = 2;
                
                for(int d=0 ; d<4 ; d++){
                    bfs( grid, r+dir[d], c+dir[d+1] , q );
                }
                
            }
            
        }
        return -1;
    }
}
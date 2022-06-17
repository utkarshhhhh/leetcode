class Solution {
    class Pair{
        int x, y;
        
        Pair( int i, int j){
            x = i;
            y = j;
        }
        
    }
    
    private void dfs(int[][] grid, int r, int c, Queue<Pair> q){
        
        if( r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] != 1 ){
            return ;
        }
        grid[r][c] = 2;
        q.add( new Pair(r,c) );
        dfs( grid, r+1, c, q );
        dfs( grid, r-1, c, q );
        dfs( grid, r, c+1, q );
        dfs( grid, r, c-1, q );

    }
    
     private void helper(int[][] grid, int r, int c, boolean[][] vis, Queue<Pair> q){
        
        if( r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == 2 || vis[r][c]){
            return ;
        }
         
        q.add( new Pair(r,c) );
    }
    
    private int bfs( int[][] grid, int i, int j){
        
        Queue<Pair> q = new LinkedList<>();
        q.add( new Pair(i,j) );
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int ans = -1;
        while( q.size() > 0 ){
            
            int size = q.size(); 
            ans++;

            for(int l=0 ; l<size ; l++){
             
                Pair p = q.poll();
                int r = p.x, c = p.y;
                if( vis[r][c] ){
                    continue;
                }
                vis[r][c] = true;
                if( grid[r][c] == 1 ){
                    return ans;
                }
                
                helper( grid, r+1, c, vis, q );
                helper( grid, r-1, c, vis, q );
                helper( grid, r, c+1, vis, q );
                helper( grid, r, c-1, vis, q );
            }
        }
        
        return 10000;
    }
    
    
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        boolean found = false;
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if( grid[i][j] == 1 ){
                    dfs(grid,i,j,q);
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        
        int ans = 10000;
        
        while( q.size() > 0 ){
            Pair curr = q.poll();
            int cur = bfs( grid, curr.x, curr.y );
            ans = Math.min( cur-1, ans );
        }
        return ans;
    }
}
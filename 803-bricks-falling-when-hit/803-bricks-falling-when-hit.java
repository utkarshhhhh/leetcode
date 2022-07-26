class Solution {
    
    static int[] dir = { 0 , 1, 0, -1, 0 };
    
    void handle(int r, int c, int[][] grid){
        
        int n = grid.length, m = grid[0].length;
        
        int cur = r*m + c + 1;
        for(int d=0 ; d<4 ; d++){
            int x = r + dir[d];
            int y = c + dir[d+1];
            
            if( x<0 || x==n || y<0 || y==m )
                continue;            
            if(  grid[x][y] == 1)
            union( cur, x*m + y + 1 );
        }
        if( r==0 )
            union( 0,cur);
    }
    
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        int n = grid.length, m = grid[0].length;
        
        parent = new int[n*m+1];
        rank = new int[n*m+1];
        size = new int[n*m+1];
        
        for(int i=0 ; i<n*m+1 ; i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        for(int[] x : hits){            
            if( grid[ x[0] ][ x[1] ] == 1 )
                grid[ x[0] ][ x[1] ] = 2;
        }
        
        for( int i=0 ; i<n ; i++ ){
            for( int j=0 ; j<m ; j++ ){
                if( grid[i][j] == 1 )
                    handle( i,j, grid );
            }
        }
        
        int[] ans = new int[hits.length];
        
        for( int i=hits.length-1; i>=0 ; i-- ){
            
            int r = hits[i][0], c = hits[i][1];
            if( grid[r][c] == 2 ){
            
                grid[r][c] = 1;
                int cur = size[find(0)];            
                handle( r, c , grid );
                int newS = size[find(0)];            
                if( cur < newS ){
                    ans[i] = newS - cur - 1;
                }
                
            }
                        
        }
        
        return ans;
    }
    
    int[] parent, rank, size;
     
    void union(int X, int Y){
        
        int x = find(X);
        int y = find(Y);
        
        if( x==y ) return;
        
        if( rank[x] > rank[y] ){
            parent[y] = x;
            size[x] += size[y];
        }else if( rank[x] < rank[y] ){
            parent[x] = y;
            size[y] += size[x];
        }else{
            parent[x] = y;
            rank[y]++;
            size[y] += size[x];
        }
    }
    
    int find(int x){
        if( parent[x] == x ) return x;
        return parent[x] = find(parent[x]);
    }
    
}
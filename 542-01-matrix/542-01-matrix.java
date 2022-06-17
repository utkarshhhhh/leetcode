class Solution {
    
    class Pair{
        int x , y, lvl;
        Pair(int i, int j, int l){
            x = i;
            y = j;
            lvl = l;
        }
    }
    
    private void init(int[][] mat, Queue<Pair> q){
        
        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                
                if( mat[i][j] == 0 ){
                    q.add(new Pair(i,j,0));
                }else{
                    // mat[i][j] = 10000000;
                }                
            }
        }
        
    }
    
    
    private void dfs(boolean[][] vis, int r, int c, int lvl , Queue<Pair> q){
        
        if( r<0 || c<0 || r >= vis.length || c >= vis[0].length || vis[r][c]){
            return;
        }
        
        // mat[r][c] = 6;
        q.add( new Pair(r,c,lvl) );
        
    }
    
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length, m = mat[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][m];
        
        
        init(mat, q);
        
        while( !q.isEmpty() ){
            
            Pair cur = q.poll();
            int r = cur.x, c = cur.y, lvl = cur.lvl;
            
            if( vis[r][c] ){
                continue;
            }
            vis[r][c] = true;
            
            mat[r][c] = lvl;
            
            dfs( vis, r+1, c, lvl + 1, q );    
            dfs( vis, r-1, c, lvl + 1, q );    
            dfs( vis, r, c+1, lvl + 1, q );    
            dfs( vis, r, c-1, lvl + 1, q );  
        }
        
        return mat;
    }
}
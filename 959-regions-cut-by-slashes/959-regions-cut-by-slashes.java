class Solution {
    
    int[] parent, rank;
    int n, count;
    
    public int regionsBySlashes(String[] grid) {
        
        n = grid.length;
        count = 4*n*n;
        
        parent = new int[ 4*n*n ];
        rank = new int[ 4*n*n ];
        
        for(int i=0 ; i<4*n*n ; i++){
            parent[i] = i;
        }
        
        /*
          0
         3 1
          2
        */
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
           
                // int c = i*n + j;
                // merger up left
                
                if( i>0 )
                    union( getCellNo(i,j,0) , getCellNo(i-1,j, 2) );
                if( j>0 )
                    union( getCellNo(i,j,3) , getCellNo(i,j-1, 1) );
                
                
                if( grid[i].charAt(j) != '\\' ){
                    
                    union( getCellNo(i,j,0) , getCellNo(i,j, 3) );
                    union( getCellNo(i,j,1) , getCellNo(i,j, 2) );
                    
                }
                if( grid[i].charAt(j) != '/' ){
                    
                    union( getCellNo(i,j,0) , getCellNo(i,j, 1) );
                    union( getCellNo(i,j,2) , getCellNo(i,j, 3) );
                    
                }
                
            }
        }
        return count;
    }
    
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);  //path compression
        }
        return parent[x];
    }
    public void union(int x, int y) {
        x = find(x); y = find(y);
        if (x != y) {
            parent[x] = y;
            count--;
        }
    }
    
    public int getCellNo(int r, int c, int x){
        return 4*(r*n + c) + x;
    }
    
}
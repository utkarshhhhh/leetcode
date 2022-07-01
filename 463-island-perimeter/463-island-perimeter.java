class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int ans = 0;
        int r = grid.length, c = grid[0].length;
        
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                
                if( grid[i][j] == 1 ){
                
                    int cur = 4;
                
                    if( i-1>=0 ){
                        cur -= grid[i-1][j];
                    }
                    if( j-1>=0 ){
                        cur -= grid[i][j-1];
                    }                
                    if( i+1 < r ){
                        cur -= grid[i+1][j];
                    }             
                    if( j+1 < c ){
                        cur -= grid[i][j+1];
                    }                
                    ans += cur;                    
                }
                
            }
        }
        return ans;
    }
}
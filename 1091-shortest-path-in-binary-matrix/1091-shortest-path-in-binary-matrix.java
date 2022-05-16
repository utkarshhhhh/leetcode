class Solution {
    
    int[][] dir = { {0,1} , {1,0} , {-1,0} , {0,-1} , {1,1} , {1,-1} , {-1,1} , {-1,-1}  };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if( grid[0][0] == 1 ) return -1;
        if( grid[0][0] == 0 && grid.length == 1 ) return 1;
        int ans = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        while( !q.isEmpty() ){
            
            int size = q.size();
            
            while( size-- > 0 ){
                
                int[] temp = q.poll();
                int r = temp[0] , c = temp[1];
                
                for(int i=0 ; i<8 ; i++){
                    int x = r + dir[i][0];
                    int y = c + dir[i][1];
                    
                    if( x >= 0 && x < grid.length && y >= 0 && y < grid.length && grid[x][y] == 0 ){
                        
                        if( x == grid.length-1 && y == grid.length-1){
                            return ans+1;
                        }
                        grid[x][y] = 1;
                        q.add( new int[]{x,y} );
                    }
                }
                
            }
            ans++;
        }        
        return -1;
    }
}
class Solution {
    
    static int max = 0;
	static int[] dir = {0,1,0,-1,0};
	public static int find(int[][] arr,boolean[][] vis, int r, int c){
	    
	    
	    if( r<0 || c<0 || r==arr.length || c==arr[0].length || vis[r][c] || arr[r][c] == 0 ){
	           return 0;
	    }
	    
	    vis[r][c] = true;
	    int sum = 0;
	    
	    for(int d=0 ; d<4 ; d++){
	        sum = Math.max( sum, find(arr, vis, r + dir[d] , c + dir[d+1]) );
	    }
        vis[r][c] = false;
	    return sum + arr[r][c];
	}
	
    public int getMaximumGold(int[][] grid) {
        
        int max = 0;
        int n = grid.length , m = grid[0].length;
		boolean[][] vis = new boolean[n][m];
		
		for(int i=0 ; i<n ; i++){
		    for(int j=0 ; j<m ; j++){
		        
		        if( grid[i][j] != 0 && !vis[i][j] ){
		            int cur = find(grid,vis, i,j);
		            
		            max = Math.max(max, cur);
		        }
		        
		    }
		}
        return max;
    }
}
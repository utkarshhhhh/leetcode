// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find whether a path exists from the source to destination.
    int[] dir = { 0,1,0,-1,0 };
    public boolean dfs(int[][] grid , int sr,int sc){
        
        if( grid[sr][sc] == 2 ){
            return true;
        }
        
        grid[sr][sc] = 4;
        
        for(int i=0 ; i<4; i++){
            
            int x = sr + dir[i];
            int y = sc + dir[i+1];
            
            if( x>=0 && x<grid.length && y>=0 && y<grid[sr].length && !( grid[x][y]==0 || grid[x][y] == 4 ) ){
                
                if(dfs( grid, x, y )){
                 return true;
                }
            }
         }
        
        grid[sr][sc] = 3;
        return false;
    }
    
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid.length ; j++){
                if( grid[i][j] == 1 )
                    return dfs(grid, i,j);
            }
        }
        return false;
    }
}
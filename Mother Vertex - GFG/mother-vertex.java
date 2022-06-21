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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        
        int motherV = 0;
        
        boolean[] vis = new boolean[V];
        for(int s=0 ; s<V ; s++){
            if( !vis[s] ){
                dfs( s, adj, vis );
                motherV = s;
            }
        }
        
        vis = new boolean[V];
        dfs( motherV, adj, vis );
        
        for(int s=0 ; s<V ; s++){
            if( !vis[s] ){
                return -1;    
            }
        }
        return motherV;
    }
    
    public void dfs(int s, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        
        vis[s] = true;
        for(int child : adj.get(s) ){
            
            if(!vis[child]){
                dfs(child, adj, vis);
            }
        }
    }
}
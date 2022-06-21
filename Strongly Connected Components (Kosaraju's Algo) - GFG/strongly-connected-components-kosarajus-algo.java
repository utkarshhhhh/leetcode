// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public void dfsStack(int s, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st){
        
        vis[s] = true;
        for(int child : adj.get(s) ){
            
            if(!vis[child]){
                dfsStack(child, adj, vis, st);
            }
        }
        st.push(s);
    }
    
    public void dfs(int s, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        
        vis[s] = true;
        for(int child : adj.get(s) ){
            
            if(!vis[child]){
                dfs(child, adj, vis);
            }
        }
    }
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // put all connected components in st
        
        Stack<Integer> st = new Stack<Integer>();
        boolean[] vis = new boolean[V];
        
        for(int i=0 ; i<V ; i++){
            if( !vis[i] ){
                dfsStack( i, adj, vis, st );
            }
        }
        
        // reverse edges
        ArrayList<ArrayList<Integer>> tsp = new ArrayList<>();
        
        for(int i=0 ; i<V ; i++)
            tsp.add( new ArrayList<Integer>() );

        for( int i=0 ; i<V ; i++ ){
            for( int nbr : adj.get(i)  ){
                tsp.get(nbr).add(i);
            }
        }

        // count        
        vis = new boolean[V];
        int count = 0;
        
        while( st.size() > 0 ){
            
            int i = st.pop();
            if( !vis[i] ){
                dfs( i, tsp, vis);
                count++;
            }
            
        }
        return count;
    }
}

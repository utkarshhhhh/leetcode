// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    // static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    // {
    //     // add your code here
    //     // kahn
        
    //     int[] in = new int[V];
    //     for( ArrayList<Integer> list : adj ){
    //         for(int i : list){
    //             in[i]++;
    //         }
    //     }
        
    //     Queue<Integer> q = new ArrayDeque<>();
        
    //     for(int i=0 ; i<V ; i++){
    //         if( in[i] == 0 ) q.add(i);
    //     }
    //     // init comp
        
    //     int[] ans = new int[V];
    //     int idx = 0;
    //     while( q.size() > 0 ){
            
    //         int cur = q.poll();
    //         ans[idx++] = cur;
            
    //         for( int nbr : adj.get(cur) ){
    //             in[nbr]--;
                
    //             if(in[nbr] == 0) q.add(nbr);
    //         }
            
    //     }
    //     return ans;
    // }
    
    static void dfs(int s, ArrayList<ArrayList<Integer>> graph, boolean[] vis, Stack<Integer> st ){
        
        if( vis[s] ){
            return;
        }
        
        for( int nbr : graph.get(s) ){
            dfs( nbr, graph, vis, st );
        }
        
        vis[s] = true;
        st.push( s );
    }
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        // topo
        
        boolean[] vis = new boolean[V];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0 ; i<V ; i++){
            if( !vis[i] ) 
                dfs( i, adj, vis, st );
        }
        
        Collections.reverse(st);
        return st.stream().mapToInt(i->i).toArray() ;
    }
}

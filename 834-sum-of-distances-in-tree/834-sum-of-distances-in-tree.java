class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        int[] nodes = new int[n];
        // Arrays.fill(1);
        int[] ans = new int[n];
        
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0 ; i<n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] a : edges){
            graph[a[0]].add(a[1]);
            graph[a[1]].add(a[0]);
        }
        dfs1(graph,nodes,ans,0,-1); 
        dfs2(graph,nodes,ans,0,-1); 
        return ans;
    }
    
    private void dfs1(ArrayList<Integer>[] graph,int[] nodes,int[] ans, int s, int p){
        
        for( Integer i : graph[s] ){
            if( i != p ){
                dfs1(graph,nodes,ans,i,s);
                nodes[s] += nodes[i];
                ans[s] += ans[i] + nodes[i];
            }
        }
        nodes[s]++;
    }
    
    private void dfs2(ArrayList<Integer>[] graph,int[] nodes,int[] ans, int s, int p){
        
        for( Integer i : graph[s] ){
            if( i != p ){
                ans[i] = ans[s] + (nodes.length - nodes[i]) - nodes[i];
                dfs2(graph,nodes,ans,i,s);
            }
        }
    }
    
}
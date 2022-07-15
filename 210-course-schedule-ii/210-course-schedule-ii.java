class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        
        int n = numCourses;
        for( int i=0 ; i<n ; i++ ) graph[i] = new ArrayList<>();
        
        for( int[] pre : prerequisites ){
            graph[ pre[0] ].add( pre[1] ); 
        }        
        // graph made 
        
        int[] in = new int[ n ];
        
        for( int i=0 ; i<n ; i++ ){
            for(int x : graph[i]){
                in[x]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0 ; i<n ; i++){
            if(in[i]==0) q.add(i);
        }
        
        // init comp
        
        int[] ans = new int[n];
        int idx = n-1;
        while( q.size() > 0 ){
            
            int cur = q.poll();
            ans[idx--] = cur;
            
            for(int nbr : graph[cur]){
                in[nbr]--;
                
                if( in[nbr] == 0 ) q.add( nbr );
            }            
        }
        
        if( idx != -1 ) return new int[0];        
        return ans;
    }
}
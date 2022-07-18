class Solution {
    
    int[] parent, rank;
    
    public int find(int c){
        if( parent[c] == c ) return c;
        return parent[ c ] = find( parent[c] );
    }
    
    public void union(int a, int b){
        
        if( rank[a] < rank[b]  ){
            parent[a] = b;
        }else if( rank[a] > rank[b]  ){
            parent[b] = a;
        }else{
            parent[b] = a;
            rank[a]++;
        }
        
    }
    
    public boolean equationsPossible(String[] equations) {
        
        parent = new int[123];
        rank = new int[123];
        
        for(char i='a' ; i<='z' ; i++){
            parent[i] = i;
        }
        
        Queue<String> q = new LinkedList<>();
        
        for(String s : equations){
            
            char not = s.charAt(1);
            char a = s.charAt(0), b = s.charAt(3);
            
            if( not == '!' ){
                // if( parent[ a-'a' ] == parent[ b-'a' ] ){
                //     return false;
                // }
                q.add(s);
            }else{
                
                int p1 = parent[a], p2 = parent[b];
                
                if( p1 != p2 ){
                    union( p1,p2 );
                }
                
            }
            
        }
        
        while( q.size() > 0 ){
            
            String s = q.poll();
            char a = s.charAt(0), b = s.charAt(3);
            
            if( find( a ) == find( b ) ){
                return false;
            }
        }
        
        return true;
    }
}
class Solution {
    
    String get(int[][] b){
        
        String s = "";
        for(int[] x : b){
            for(int v : x){
                s += v==0?" ": v;
            }
        }
        return s;
    }
    
    int find(String s){
        
        for(int i=0 ; i<6 ; i++){
            if( s.charAt(i) == ' ' ) return i;
        }
        return -1;
    }
    
    String swap(String s, int i, int j){
        StringBuilder sb = new StringBuilder(s);
        
        char c = sb.charAt(i), d = sb.charAt(j);
        sb.setCharAt( i, d );
        sb.setCharAt( j, c );
        return sb.toString();
    }
    
    /*
    123     012
    456 ->  345
    */
    static int[][] dir = { {1,3}, {0,2,4} ,{1,5}, {0,4}, {3,1,5}, {2,4} };
    
    public int slidingPuzzle(int[][] board) {
        
        HashSet<String> hash = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add( get(board) );
        String end = "12345 ";
        
        
        
        int ans = 0;
        while( q.size() > 0 ){
            
            int size = q.size();
            for( int i=0 ; i<size ; i++ ){
                
                String cur = q.poll();
                
                if( cur.equals(end) ){
                    return ans;
                }
                hash.add(cur);
                int idx = find( cur );
                
                for( int d = 0 ; d<dir[idx].length ; d++ ){
                    String swappedStr = swap( cur, idx, dir[idx][d] );
                    if( !hash.contains(swappedStr) ){
                        q.add(swappedStr);
                    }
                }
                
            }
            ans++;
        }
        return -1;
    }
}
class Solution {
    
    int find(String s, String x){
        
        for(int i=0 ; i<s.length() ; i++){
            if( s.charAt(i) != x.charAt(i) ){
                return i;
            }    
        }
        return -1;
    }
    
    String swap(String s, int i, int j){
        StringBuilder sb = new StringBuilder(s);
        char a = sb.charAt(i), b = sb.charAt(j);
        sb.setCharAt( i, b );
        sb.setCharAt( j, a );
        return sb.toString();
    }
    
    public int kSimilarity(String s1, String s2) {
        
        HashSet<String> hash = new HashSet();
        Queue<String> q = new LinkedList<>();
        int ans = 0;
        q.add(s1);
        
        // bccaba
        // abacbc
        
        while( q.size() > 0 ){
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                
                String cur = q.poll();

                if( hash.contains(cur) ) continue;
                if( cur.equals(s2) ) return ans;
                
                hash.add(cur);
                
                int idx = find( cur, s2 );
                for(int j=idx+1 ; j<s1.length() ; j++){
                    
                    if( cur.charAt(j) == s2.charAt(idx) ){
                        String swapStr = swap(cur, idx, j);
                        if( !hash.contains(swapStr) ) q.add(swapStr);
                    }                    
                }
            }
            ans++;
        }
        
        return -1;
    }
}
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        HashMap< Character, Deque<String> > map = new HashMap<>();
        
        for(char c='a' ; c<='z' ; c++){
            map.put( c, new ArrayDeque<String>() );
        }
        
        for( String x : words ){
            map.get( x.charAt(0) ).add( new String(x) );
        }
        
        int ans = 0;
        for( int i=0 ; i<s.length() ; i++ ){
            char c = s.charAt(i);
            
            Deque<String> q = map.get( c );
            int size = q.size();
            for(int j=0 ; j<size  ; j++){
                
                String cur = q.poll() ;
                // cur.deleteCharAt(0);
                
                if( cur.length() == 1 ){ 
                    ans++ ;                   
                }else{
                    map.get( cur.charAt(1) ).addLast( cur.substring(1) );
                }
                
            }
        }
        return ans;
    }
}
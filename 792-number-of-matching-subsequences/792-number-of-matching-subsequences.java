class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        HashMap< Character, Deque<StringBuilder> > map = new HashMap<>();
        
        for(char c='a' ; c<='z' ; c++){
            map.put( c, new ArrayDeque<StringBuilder>() );
        }
        
        for( String x : words ){
            map.get( x.charAt(0) ).add( new StringBuilder(x) );
        }
        
        int ans = 0;
        for( int i=0 ; i<s.length() ; i++ ){
            char c = s.charAt(i);
            
            Deque<StringBuilder> q = map.get( c );
            int size = q.size();
            for(int j=0 ; j<size  ; j++){
                
                StringBuilder cur = q.poll() ;
                cur.deleteCharAt(0);
                
                if( cur.length() == 0 ){ 
                    ans++ ;                   
                }else{
                    map.get( cur.charAt(0) ).add( cur );
                }
            }
            
        }
        return ans;
    }
}
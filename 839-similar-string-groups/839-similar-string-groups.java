class Solution {
    
    boolean isSimilar(String x, String y){
        
        int c=0;
        for(int i=0 ; i<x.length() ; i++){
         
            if( x.charAt(i) != y.charAt(i) ){
                if( ++c > 2 ){
                    return false;
                }
            }            
        }
        return true;
    }
    
    public int numSimilarGroups(String[] strs) {
     
        parent = new HashMap<>();
        rank = new HashMap<>();
        
        for( String s : strs ){
            parent.put(s,s);
            rank.put(s,0);
        }
        
        for( int i=0 ; i<strs.length ; i++ ){
            for( int j=i+1 ; j<strs.length ; j++ ){                
                    if( isSimilar(strs[i], strs[j]) ){                        
                        union( strs[i], strs[j] );
                }
            }
        }
        
        int count=0;
        
        for( String s : parent.keySet() ){
            if( parent.get(s).equals(s) ){
                count++;
            }
        }
        
        return count;            
    }
    
    HashMap<String, String> parent;
    HashMap<String, Integer> rank;
    
    String find(String s){
        
        if( parent.get(s).equals(s) ){
            return s;
        }
        String np = find( parent.get(s) );
        parent.put(s, np);
        return np;
    }
    
    void union(String s1, String s2){
        
        String x = find(s1);
        String y = find(s2);
        
        if( x.equals(y) ){
            return;
        }
        
        if( rank.get(x) < rank.get(y) ){
            parent.put( x, y );
        }else if( rank.get(x) > rank.get(y) ){
            parent.put( y, x );
        }else{            
            parent.put( y, x );
            rank.put( x, rank.get(x)+1 );
        }        
    }
    
}
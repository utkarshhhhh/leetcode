class Solution {
    
    List<List<String>> Ans ;
    
    boolean pal(String s, int i, int j){
        
        // int i = 0 , j = ;
        while( i<j ){
            if( s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
    
    public void helper(String s, int st, List<String> ans){
        
        if( st >= s.length() ){
            // ans.add(s);
            Ans.add( new ArrayList<>(ans) );
            return;
        }
        
        for( int end = st ; end<s.length() ; end++ ){
            
            if( pal( s, st, end ) ){
                
                ans.add( s.substring(st, end+1) );
                helper( s, end+1, ans );
                // ans.remove( s.substring(st, end+1) );
                ans.remove( ans.size()-1 );
            }            
        }        
    }
    
    public List<List<String>> partition(String s) {
        
        Ans = new ArrayList<>();
        helper( s, 0, new ArrayList<String>() );
        return Ans;
        
    }
}
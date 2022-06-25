class Solution {
    
    HashMap<String , Boolean> map = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        
        String cur = s1+s2;
        if( map.containsKey( cur ) ){
            return map.get( cur );
        }
        
        if( s1.equals(s2) ){
            map.put(cur, true);
            return true;
        }
        
        int n = s1.length();
        
        int[] hash1 = new int[26];
        
        for( int i = 0 ; i<n ; i++ ){
            hash1[ s1.charAt(i)- 'a' ]++;
            hash1[ s2.charAt(i)- 'a' ]--;
        }
        for( int i = 0 ; i<26 ; i++ ){
            if( hash1[i] != 0 ){              
                map.put( cur, false );
                return false;
            } 
        }
        
        
        for( int i=1 ; i<n ; i++ ){
            
            boolean temp1 = isScramble( s1.substring(0,i), s2.substring(0,i) );
            boolean temp2 = isScramble( s1.substring(i), s2.substring(i) );
            
            if( temp1 && temp2 ){
                map.put( cur, true );
                return true;
            } 
            
            boolean temp3 = isScramble( s1.substring(0,i), s2.substring(s2.length()-i) );
            boolean temp4 = isScramble( s1.substring(i), s2.substring(0,s2.length()-i) );
            
            if( temp3 && temp4 ){
                map.put( cur, true );
                return true;
            } 
        }
        
        map.put(cur, false);
        return false;
    }
}
class Solution {
    public String minWindow(String s, String t) {
        
        if( s.length() < t.length() )
        return "";
        
        int ans = Integer.MAX_VALUE, st = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i<t.length() ; i++)
            map.put( t.charAt(i), map.getOrDefault(t.charAt(i),0)+1 );
        
        int count = map.size();
        
        int i=0, j = 0;
        while( j<s.length() ){
            
            char c = s.charAt(j);
            
            if( map.containsKey(c) ){
                map.put( c, map.get(c)-1 );
                
                if(map.get(c) == 0) count--;
            }
            j++;
            
            while( count == 0 ){
                
                char ch = s.charAt(i);
                if( map.containsKey( ch ) ){
                    
                    map.put( ch, map.get(ch)+1 );
                    
                    if(map.get(ch) > 0) count++;
                }

                
                // if( j-i == t.length() ){
                    
                    if( j-i <= ans ){
                        ans = Math.min( j-i, ans );    
                        st = i;
                    }
                    
                // }
                i++;
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(st, st+ans);
        
    }
}
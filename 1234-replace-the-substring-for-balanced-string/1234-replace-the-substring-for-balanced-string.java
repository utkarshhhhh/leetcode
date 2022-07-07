class Solution {
    public int balancedString(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int n = s.length();
        for( int i=0 ; i<n ; i++ ){            
            map.put( s.charAt(i), map.getOrDefault( s.charAt(i), 0 ) +1 );            
        }

        HashMap<Character, Integer> hash = new HashMap<>();

        for(char c : map.keySet() ){
            if( map.get(c) > n/4 ){
                hash.put(c, map.get(c) - n/4 );              
            }
        }
        
        // return map.get('E');
        if(hash.size() == 0) return 0;
        
        int count  = hash.size(), ans = n, st = 0;
        
        for(int i=0 ; i<n ; i++){
            
            if( hash.containsKey( s.charAt(i) ) ){                
                hash.put( s.charAt(i), hash.get(s.charAt(i)) -1 );
                if( hash.get(s.charAt(i)) == 0 ) count--;
            }
            
            while( count == 0 ){
                
                if( hash.containsKey( s.charAt(st) ) ){
                    hash.put( s.charAt(st), hash.get(s.charAt(st)) +1 );
                    if( hash.get(s.charAt(st)) == 1 ) count++;
                }
                ans = Math.min( ans, i - st + 1 );
                st++;
            }
            
        }
        return ans;
    }
}
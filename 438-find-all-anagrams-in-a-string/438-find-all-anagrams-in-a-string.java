class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans = new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i<p.length() ; i++)
            map.put( p.charAt(i), map.getOrDefault(p.charAt(i),0)+1 );
        
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

                
                if( j-i == p.length() ){
                    ans.add(i);
                }
                i++;
            }
        }
        return ans;
    }
}
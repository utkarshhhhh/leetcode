class Solution {
    
    public List<Integer> findSubstring(String s, String[] words) {
        
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        int len = words[0].length();
        for(String x : words){
            map.put( x, map.getOrDefault(x,0) +1 );
        }
        
        for( int i=0 ; i<= s.length() - len*words.length ; i++ ){
            
            HashMap<String , Integer> cur = new HashMap<>(map);
            
            for(int j=0 ; j<words.length ; j++ ){
             
                String c = s.substring( i + j*len, i + j*len + len );
                
                if( cur.containsKey(c) ){
                    
                    cur.put( c, cur.get(c)-1 );
                    if( cur.get(c) == 0 ) cur.remove(c);
                    if( cur.size() == 0 ) {
                        ans.add(i);
                        break;
                    }                    
                }else{
                    break;
                }                
            }
            
        }
        
        return ans;
    }
}
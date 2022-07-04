class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String str : strs){
            
            char[] arr = new char[26];
            for( int i=0 ; i<str.length() ; i++ ) 
                arr[ str.charAt(i) - 'a' ]++;
            
            String key = String.valueOf( arr );
            
            if( !map.containsKey(key) ) map.put( key, new ArrayList<>() );
            
            map.get(key).add(str);
        }
        
        return new ArrayList<>( map.values() );
    }
}
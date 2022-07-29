class Solution {
    
    String change(String s){
        
        StringBuilder sb = new StringBuilder();
        
        HashMap<Character, Character> map = new HashMap<>();
        
        char c = 'a';
        for( int i=0 ; i<s.length() ; i++ ){
            char ch = s.charAt(i);
            if( !map.containsKey( ch ) ){                
                map.put( ch, c );
                c++;
            }
            sb.append( map.get(ch) );
        }
        return sb.toString();
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> list = new ArrayList<>();
        
        String pat = change(pattern);
        for(String s : words){
            if( pat.equals( change(s) ) ){
                list.add(s);
            }
        }
        return list;
    }
}
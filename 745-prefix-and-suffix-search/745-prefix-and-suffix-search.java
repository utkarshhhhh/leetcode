class WordFilter {
    
    HashMap<String, Integer> map = new HashMap<>();
    
    // String[] input ;
    
    public WordFilter(String[] words) {
        
        for(int i=0 ; i<words.length ; i++ ){
            
            String str = words[i];
            for(int j=1 ; j<=str.length() ; j++){
            
                String p = str.substring(0,j);
                
                for(int k = 0; k<str.length() ; k++){
                    
                    String s = str.substring(k);
                    
                    map.put( p+"|"+s , i);
                }
            }
        }
        
    }
    
    public int f(String prefix, String suffix) {
        
        String cur = prefix + "|" + suffix;
        
        if( map.containsKey(cur) ) return map.get(cur);
        
        return -1;
        
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
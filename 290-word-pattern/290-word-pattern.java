class Solution {
    
    // points to consider ::
    // one to one mappin of pat char and word[i]
    // revHash --- map string to pat char
    
    public boolean wordPattern(String pattern, String s) {
        
        String[] str = s.split(" ");
        
        if( pattern.length() != str.length ){
            return false;
        }
        
        HashMap<Character, String> hash = new HashMap<>();
        HashMap<String, Character> revHash = new HashMap<>();
        
        for(int i=0 ; i<pattern.length() ; i++){
            
            char p = pattern.charAt(i);
            String word = str[i];
            
            if( revHash.containsKey(word) ){
                
                if( revHash.get(word) != p ){
                    return false;
                }
                
            }else{
                
                revHash.put(word, p);
                
            }
            
            if( hash.containsKey(p)){                
                if( !hash.get(p).equals( word ) ){
                    return false;
                }
            }else{
                hash.put(p,str[i]);
            }
            
        }
        return true;
    }
}
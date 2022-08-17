class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String[] hash = { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.." };
        
        HashSet<String> set = new HashSet<>();
        
        for(String s : words){
            
            StringBuilder sb = new StringBuilder();
            
            for( int i=0 ; i<s.length() ; i++ ){
                sb.append( hash[ s.charAt(i)-'a' ] );
            }
            set.add(sb.toString());
        }
            
        return set.size();
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort( products );
        
        List<List<String>> ans = new ArrayList<>();
        String s = "";
        
        for(char c : searchWord.toCharArray() ){
            
            s += c;
            
            List<String> cur = new ArrayList<>();
            
            for(String word : products){
                
                if( word.startsWith( s ) ){
                    cur.add(word);
                    if( cur.size() == 3 ) break;
                }
                
            }
            ans.add( cur );
        }
        
        return ans;
    }
}
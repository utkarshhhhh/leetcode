class Solution {
    
    public int bitmask(String s){
        int mask = 0;
        for(char c : s.toCharArray()){
            int ch = c-'a';
            mask = (mask | (1<<ch));
        }
        return mask;
    }
    
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for(String word : words){
        
        int mask = bitmask(word);
        map.put( mask, map.getOrDefault(mask, 0) + 1 );
                
    }
    
    ArrayList<Integer> ans = new ArrayList<>();
    
    for(String puzzle : puzzles){
        
        
        
        int firstLetter = 1 << (puzzle.charAt(0)-'a') ;
        int count = map.getOrDefault( firstLetter , 0 );
        int pmask = bitmask(puzzle.substring(1));
        
        for(int submask = pmask ; submask > 0 ; submask = (submask-1)&pmask ){
            
            count += map.getOrDefault( submask|firstLetter, 0 );            
        }
        
        ans.add(count);
    }
    
    return ans;
    }
}
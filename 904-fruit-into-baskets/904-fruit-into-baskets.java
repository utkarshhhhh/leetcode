class Solution {
    public int totalFruit(int[] fruits) {
        
        int count =0, st = 0, len = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0 ; i<fruits.length ; i++){
            
            int f = fruits[i];
            
            map.put(  f,  map.getOrDefault(f, 0) + 1 );
            
            if( map.get(f) == 1 ) count++;
            
            while( count > 2 ){
                
                map.put( fruits[st], map.get(fruits[st]) -1 );
                if( map.get(fruits[st]) == 0) count--;
                st++;
            }
            
            len = Math.max( len, i-st + 1 );
        }
        return len;
    }
}
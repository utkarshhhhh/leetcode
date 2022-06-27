class Solution {
    public boolean canCross(int[] stones) {
     
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int x : stones){
            map.put( x, new HashSet<Integer>() );
        }
        
        int tar = stones[ stones.length-1 ];
        
        map.get(0).add(1);
        
        for(int x : stones){
            
            for( int ch : map.get(x) ){
                
                // if( ch == -1 ) continue;
                
                int cur = x + ch;
                
                if( cur == tar )
                    return true;
                
                if( cur != x && map.containsKey(cur) ){
                    map.get(cur).add( ch-1 );
                    map.get(cur).add( ch );
                    map.get(cur).add( ch+1 );
                }
                
            }
            
        }
        return false;
    }
}
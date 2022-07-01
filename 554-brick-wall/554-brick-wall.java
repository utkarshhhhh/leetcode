class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        
        for( List<Integer> l : wall ){
            int prev = 0;
            for( int i=0 ; i<l.size()-1 ; i++ ){
                
                prev += l.get(i);
                map.put( prev, map.getOrDefault( prev, 0 ) + 1 );
                
                ans = Math.max( ans, map.get(prev) );
            }
        }
        return wall.size() - ans;
    }
}
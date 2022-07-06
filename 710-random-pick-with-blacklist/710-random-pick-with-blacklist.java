class Solution {

    HashMap<Integer, Integer> map ;
    HashSet<Integer> set = new HashSet<>();
    int top;
    
    Random r = new java.util.Random();
    
    public Solution(int n, int[] blacklist) {
        
        map = new HashMap<>();
        set = new HashSet<>();
        
        for(int x : blacklist) set.add( x );
        
        top = n - blacklist.length;
        
        for(int x : blacklist){            
            if( x < top ){                
                while( set.contains( n-1 ) ){
                    n--;
                }
                map.put(x, n-1);
                n--;
            }            
        }        
    }
    
    public int pick() {
        int idx = r.nextInt(top);
        return map.containsKey( idx ) ? map.get(idx) : idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
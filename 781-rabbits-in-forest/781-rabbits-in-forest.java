class Solution {
    public int numRabbits(int[] answers) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for( int x : answers ){            
            map.put(x, map.getOrDefault( x,0 ) + 1 );            
        }
        
        int ans = 0;
        for(int key : map.keySet()){            
            ans += (int)Math.ceil( (map.get(key)*1.0 )/(key+1) )*(key+1);
        }
        
        return ans;
    }
}
class Solution {
    
    private int gcd(int a, int b){
        if(b==0) return a;
        
        return gcd( b, a%b );
    }
        
    public boolean hasGroupsSizeX(int[] deck) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int x : deck){
            map.put( x, map.getOrDefault( x, 0 ) +1 );
        }
        
        int ans = map.get( deck[0] );
        
        for( Integer key : map.keySet() ){
            ans = gcd(ans, map.get(key));
        }
        
        return ans >= 2;
    }
}
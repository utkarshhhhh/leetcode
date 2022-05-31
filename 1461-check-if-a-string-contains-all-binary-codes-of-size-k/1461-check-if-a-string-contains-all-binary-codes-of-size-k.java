class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        if( s.length() <= k ){
            return false;
        }
        
        Set<Integer> hash = new HashSet<>();
        
        int cur = 0;
        for(int i=0 ; i<k ; i++){
            int c = s.charAt(i) - '0';
            cur = (cur<<1)|c;
        }
        hash.add(cur);
        
        int prev = (1<<(k-1)) - 1;
        for(int i=k ; i<s.length() ; i++){
            
            int c = s.charAt(i) - '0';            
            cur &= prev;
            cur = (cur<<1)|c;
            
            hash.add(cur);
        }
        return hash.size() == (1<<k) ;
    }
}
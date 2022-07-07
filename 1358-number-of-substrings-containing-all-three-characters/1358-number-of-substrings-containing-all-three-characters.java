class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] count = { -1, -1, -1 };
        int ans = 0;
        
        for(int i=0 ; i<s.length() ; i++){
            count[ s.charAt(i) - 'a' ] = i;
            
            ans += 1+Math.min( count[0], Math.min(count[1], count[2]) );
            
        }
        return ans;
    }
}
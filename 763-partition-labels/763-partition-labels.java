class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int[] hash = new int[26];
        for(int i=0 ; i<s.length() ; i++){
            hash[s.charAt(i)-'a'] = i;
        }
        
        List<Integer> ans = new ArrayList<>();
        int st = -1, end = 0;
        for(int i=0 ; i<s.length() ; i++){
            
            end = Math.max( hash[s.charAt(i)-'a'], end );
            if( end == i ){
                ans.add( end-st );
                st = i;
            }
            
        }
        return ans;
    }
}
class Solution {
    public int firstUniqChar(String s) {
        
        int n = s.length();
        int[] hash = new int[26];
        
        for( int i=0 ; i<s.length() ; i++ ){
            hash[s.charAt(i)-'a']++;
        }
        
        int idx = -1;
        
        for( int i=0 ; i<s.length() ; i++ ){
            if(hash[s.charAt(i)-'a'] == 1){
                idx = i;
                break;
            }
        }
        
        
        return idx;
    }
}
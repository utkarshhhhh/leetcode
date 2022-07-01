class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        
        for(int i = 0 ;  i<s.length() ; i++){
            
            char a = s.charAt(i), b = t.charAt(i);
            
            if( map1.containsKey( a ) ){
                if( map1.get(a) != b ) return false;
            }
            
            if( map2.containsKey( b ) ){
                if( map2.get(b) != a ) return false;
            }
            
            map1.put(a,b);
            map2.put(b,a);
        }
        
        return true;
    }
}
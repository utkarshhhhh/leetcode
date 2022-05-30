class Solution {
    
    /*
    app 1 : stringBuilder hash
    app 2 : bit mask <<2
    */
    public List<String> findRepeatedDnaSequences(String s) {
        
        if(s.length() < 10) return new ArrayList<>();
        
        int[] hash = new int[26];
        hash['A'-'A'] = 0;
        hash['C'-'A'] = 1;
        hash['G'-'A'] = 2;
        hash['T'-'A'] = 3;
        
        List<String> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        
        int cur = 0;
        // StringBuilder sb = new StringBuilder();
        
        for(int i=0 ; i<9 ; i++){
            cur <<= 2;            
            cur |= hash[ str[i]-'A' ];            
        }
        
        for(int i=9 ; i<str.length ; i++ ){
            
            cur <<= 2;
            cur &= 0xfffff;
            cur |= hash[ str[i]-'A' ];
            
            if( map.containsKey(cur) ){
                if(map.get(cur) == 1)
                    ans.add( s.substring(i-9 , i+1) );
                map.put( cur, 2 );
            }else{
                map.put(cur, 1);
            }
            
        }
        return ans;
    }
}
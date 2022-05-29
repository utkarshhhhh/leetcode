class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int[] hash = {0,1,2,3};
        
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<str.length ; i++ ){
            
            sb.append( str[i] );
            if( i < 9 ){                
                continue;
            }
            
            if( i!=9 )
                sb.delete(0,1);
            
            String cur = sb.toString();
            
            if( map.containsKey(cur) ){
                if(map.get(cur) == 1)
                    ans.add(cur);
                map.put( cur, 2 );
            }else{
                map.put(cur, 1);
            }
            
        }
        return ans;
    }
}
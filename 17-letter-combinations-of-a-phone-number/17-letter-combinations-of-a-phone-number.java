class Solution {
    
    String[] phone = { "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz" };
    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();
        
        if( digits.length() == 0 ){
            //ans.add("");
            return ans;
        }
        
        int ch = (digits.charAt(0) - '2');
        List<String> cur = letterCombinations( digits.substring(1) );
        if(cur.size() == 0) cur.add("");
        
        for(int i=0 ; i<phone[ch].length() ; i++){
            char c = phone[ch].charAt(i);
            for(int j=0 ; j<cur.size() ; j++){
                ans.add( c+cur.get(j) );
            }
            
        }
        return ans;
    }
}
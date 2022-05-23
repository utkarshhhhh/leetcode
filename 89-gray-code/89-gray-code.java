class Solution {
    
    public List<String> helper(int n){
        if( n==1 ){
            List<String> base = new ArrayList<>();
            base.add("0");
            base.add("1");
            return base;
        }
        
        List<String> prev = helper(n-1);
        
        List<String> ans = new ArrayList<>();
        for(int i=0 ; i<prev.size(); i++){
            ans.add( "0" + prev.get(i) );
        }
        
        for(int i=prev.size()-1 ; i>=0 ; i--){
            ans.add( "1" + prev.get(i) );
        }
        return ans;
    }
    
    public List<Integer> grayCode(int n) {
        
        List<String> prev = helper(n);
        
        List<Integer> ans = new ArrayList<>();
        
        for(String s : prev){
            ans.add( Integer.parseInt(s,2) );
        }
        
        return ans;
    }
}
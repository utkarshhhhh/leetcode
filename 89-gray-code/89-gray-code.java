class Solution {
    // approach 1 string
    // app2 adding int
    public List<Integer> helper(int n){
        if( n==1 ){
            List<Integer> base = new ArrayList<>();
            base.add(0);
            base.add(1);
            return base;
        }
        
        List<Integer> prev = helper(n-1);
        
        // List<Integer> ans = new ArrayList<>();
        // for(int i=0 ; i<prev.size(); i++){
        //     ans.add( "0" + prev.get(i) );
        // }
        
        //adding from last to maintain 1 diff
        int one = 1<<(n-1);
        for(int i=prev.size()-1 ; i>=0 ; i--){
            prev.add( one + prev.get(i) );
        }
        return prev;
    }
    
    public List<Integer> grayCode(int n) {
        
        return helper(n);
        
        
    }
}
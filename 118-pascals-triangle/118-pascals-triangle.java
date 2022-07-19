class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();        
        List<Integer> cur = new ArrayList<>();        
        
        cur.add(1);
        ans.add(cur);
        
        for(int r=1 ; r<numRows ; r++ ){
            
            List<Integer> prev = ans.get(r-1);        
            cur = new ArrayList<>();
            
            for(int c=0 ; c<prev.size()+1 ; c++ ){
                
                if( c==0 || c==prev.size() ){
                    cur.add( 1 );      
                }else{
                    cur.add( prev.get(c-1) + prev.get(c) );                    
                }
            }
            ans.add(cur);
        }
        
        return ans;
    }
}
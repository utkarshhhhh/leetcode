class Solution {
    
    List<String> ANS ;
    public void helper(int n,int o, int c, String ans){
        
        if( 2*n==o+c ){
            ANS.add(ans);
            return;
        }
        
        if( o<n ){
            helper( n,o+1,c, ans+"(" );
        }
        if( o > c ){
            helper( n,o,c+1, ans + ")" );
        }
        
    }
    
    public List<String> generateParenthesis(int n) {
        
        ANS = new ArrayList<>();
        helper( n ,0,0, "" );
        return ANS;
    }
}
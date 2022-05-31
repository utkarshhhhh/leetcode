class Solution {
    static List<Integer> ans ;
    public static void solve(int i, int n){
        
        if( i>n ){
            return ;
        }
        
        // List<Integer> ans = new ArrayList<>();
        
        // System.out.println(i);
        ans.add(i);
        for(int j=0 ; j<=9 ; j++){
            if( i*10+j > n ) return;
            solve( i*10+j, n);
        }
        // return ans;
    }
    
    public List<Integer> lexicalOrder(int n) {
        
        ans = new ArrayList<>();
        for(int i=1 ; i<=9 ; i++){
		    solve(i,n );
		}
        return ans;
    }
}
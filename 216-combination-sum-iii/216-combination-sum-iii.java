class Solution {
    
    public int getSum(List<Integer> list){
        int sum = 0;
        for(int i : list)
            sum += i;
        return sum;
    }
    
    List<List<Integer>> ANS ;
    
    public void helper(int k , int n , List<Integer> list, int prev){
        
        int sum = getSum(list);

        if( sum == n && k==0 ){
            ANS.add( new ArrayList<>(list) );
            return;
        }
        
        if(sum > n || k<1 ){
            return;
        }
            
        for(int i=prev+1 ; i<=9 ; i++){             
            list.add(i);
            helper( k-1, n , list, i );
            list.remove( list.size()-1 );
        }
        
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        ANS = new ArrayList<>();
        
        helper(k,n, new ArrayList<>() ,0);
        
        return ANS;
        
        
    }
}   
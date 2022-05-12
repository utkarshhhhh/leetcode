class Solution {
    
    HashSet<List<Integer>> ANS;
    public void helper(int[] nums, boolean[] vis,List<Integer> list){
        
        if(list.size() == nums.length){
            ANS.add( new ArrayList<>(list) );
            return ;
        }
        
        for(int i=0 ; i<nums.length ; i++){
            
            if( !vis[i] ){
                
                list.add( nums[i] ); vis[i] = true;
                
                helper( nums, vis, list );
                
                list.remove( list.size()-1 );  vis[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        ANS = new HashSet<>();
        helper( nums, new boolean[nums.length] , new ArrayList<Integer>() );
        
        return new ArrayList<>(ANS);
    }
}
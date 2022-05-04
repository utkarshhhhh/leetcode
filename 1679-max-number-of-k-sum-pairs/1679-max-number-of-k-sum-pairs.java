class Solution {
    public int maxOperations(int[] nums, int k) {
        
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0 ; i<nums.length ; i++){
            
            int sum = k - nums[i];
            if( map.containsKey( sum ) && map.get(sum) > 0 ){
                count++;
                map.put( sum , map.get(sum) - 1 );
                
            }else{
                map.put( nums[i] , map.getOrDefault( nums[i] , 0 ) + 1 );
            }            
        }
        return count;
    }
}
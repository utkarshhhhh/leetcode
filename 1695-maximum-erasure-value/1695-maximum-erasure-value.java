class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        HashSet<Integer> hash = new HashSet<>();
        int ans = 0, cur = 0;
//         for(int x : nums){
            
//             while( q.contains(x) ){
//                 cur -= q.peek();
//                 q.poll();
//             }
//             q.add(x);
//             cur += x; 
            
//             ans = Math.max(ans, cur);
//         }
        
        for(int i=0, j=0 ; i<nums.length ; i++){
            while( j<i && hash.contains( nums[i] ) ){
                hash.remove(nums[j]);
                cur -= nums[j++];    
            }
            
            hash.add(nums[i]);
            cur += nums[i]; 
            
            ans = Math.max(ans, cur);
        }
        
        return ans;
    }
}
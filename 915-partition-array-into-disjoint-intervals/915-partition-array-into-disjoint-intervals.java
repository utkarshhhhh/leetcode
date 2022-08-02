class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int maxTillPartition = nums[0], maxTillScan = nums[0], partitionIndex = 0;
        
        for(int i=0 ; i<nums.length ; i++){
            maxTillScan = Math.max(maxTillScan, nums[i]);
            
            if( nums[i] < maxTillPartition ){
                partitionIndex = i;
                maxTillPartition = maxTillScan;
            }
            
        }
        return partitionIndex +1;
    }
}
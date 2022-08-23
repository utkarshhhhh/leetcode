class NumArray {

    class Fenwik{
        int[] farr;
        Fenwik(int[] nums){
            farr = new int[nums.length+1];
            
            for(int i=0 ; i<nums.length ; i++){
                update( i+1, nums[i] );
            }
        }
        
        void update(int pos, int del){            
            while( pos < farr.length ){
                farr[pos] += del;
                pos += rsb(pos);
            }            
        }
        
        int sum(int pos){  
            int ans = 0;
            while( pos > 0 ){
                ans += farr[pos];
                pos -= rsb(pos);
            }        
            return ans;
        }
        
        int rsb(int pos){
            return pos&(-pos);
        }
    }
    
    Fenwik fa;
    int[] oarr;
    public NumArray(int[] nums) {
        fa = new Fenwik(nums);
        oarr = nums;
        
    }
    
    public void update(int index, int val) {
        int del = val - oarr[index];
        fa.update(index+1, del);
        oarr[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return fa.sum(right+1) - fa.sum(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
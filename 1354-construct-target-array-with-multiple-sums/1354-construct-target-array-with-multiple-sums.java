class Solution {
    public boolean isPossible(int[] target) {
     
        PriorityQueue<Long> q = new PriorityQueue<>( (a,b) -> Long.compare(b,a) );
        
        long sum = 0;
        for(int x : target){
            sum += x;
            q.offer( (long)x );
        }
        
        while( true ){
            
            long cur = q.poll();
            
            sum -= cur;
            
            if( sum==1 || cur == 1 ){ // sum  means only 1 left [ 1,x ] 
                return true;
            }
            
            if( cur < sum || sum==0 || cur%sum == 0  ){
                return false;
            }
            
            cur %= sum;
            q.offer( cur );
            sum += cur;
        }
        
    }
}
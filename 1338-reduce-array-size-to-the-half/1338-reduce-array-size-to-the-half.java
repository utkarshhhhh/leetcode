class Solution {
    public int minSetSize(int[] arr) {
        
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int x : arr){
            map.put( x, map.getOrDefault(x,0)+1 );
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>( Collections.reverseOrder() );
        
        for(int x : map.values())
            pq.add(x);
        
        int c=0, sum = 0;
        while( pq.size() > 0 ){
            
            sum += pq.poll();
            c++;
            if( sum >= n/2 ) break;            
        }
        
        return c;
    }
}
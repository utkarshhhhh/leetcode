class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort( courses, (a,b)->{
            return a[1]-b[1];
        } );
        
        int n = courses.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> b-a );
        
        int time = 0;
        for( int[] a : courses ){
            
            if( time + a[0] <= a[1] ){
                pq.offer(a[0]);
                time += a[0];
            }else if( !pq.isEmpty() && pq.peek() > a[0] ){
                time -= pq.poll() - a[0];
                pq.offer(a[0]);
            }
    
        }
        
        return pq.size();
    }
}
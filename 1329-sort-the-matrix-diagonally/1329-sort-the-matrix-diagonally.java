class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        int n = mat.length, m = mat[0].length;
        for( int i=0 ; i<n ; i++ ){
            for(int j=0 ; j<m ; j++){
                int d = i-j;
                map.putIfAbsent(d, new PriorityQueue<Integer>());
                map.get(d).add(mat[i][j]);
            }
        }
        
        for( int i=0 ; i<n ; i++ ){
            for(int j=0 ; j<m ; j++){
                int d = i-j;                
                mat[i][j] = map.get(d).poll();
            }
        }
        return mat;
    }
}
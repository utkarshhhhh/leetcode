class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int n = matrix.length, m = matrix[0].length;
        
        // presum
        for(int i=0 ; i<n ; i++){
            for(int j=1 ; j<m ; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        int ans = 0;
        for(int i=0 ; i<m ; i++){ // traversing cols
            for(int j=i ; j<m ; j++){ // traversing cols
                
                HashMap<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int sum = 0;
                
                for(int r=0 ; r<n ; r++){
                    
                    sum += matrix[r][j] - ( i>0 ? matrix[r][i-1] : 0 );      
                    ans += map.getOrDefault( sum-target, 0 );
                    map.put( sum, map.getOrDefault( sum ,0) +1 );
                    
                }                
            }
        }
        
        return ans;
    }
}
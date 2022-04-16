class Solution {
    public int[][] generateMatrix(int n) {
        
        int sr = 0 , sc = 0 , er = n-1, ec = n-1, count = 1;
        int[][] ans = new int[n][n];
        while( count <= n*n  ){

            for(int c = sc ; c<=ec ; c++ ){
                ans[sr][c] = count++;
            }   sr++;


            for(int r = sr ; r<=er ; r++ ){
                ans[r][ec] = count++;
            }   ec--;    

            
            for(int c = ec ; c>=sc ; c-- ){
                ans[er][c] = count++;
            }   er--;

            for(int r = er ; r>=sr ; r-- ){
                ans[r][sc] = count++;
            }   sc++;
        }
        
        return ans;
    }
}
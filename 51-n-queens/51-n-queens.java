class Solution {
    
    List<List<String>> Ans = new ArrayList<>();
    
    private boolean isValid(int i,int j, boolean[][] board){
        
        for(int r=0 ; r<board.length ; r++){
            if( board[r][j] ){
                return false;
            }
        }
        
        for(int c=0 ; c<board.length ; c++){
            if( board[i][c] ){
                return false;
            }
        }
        
        for(int r=i,c = j ; r>=0 && c>=0 ; r--,c--){
            if( board[r][c] ){
                return false;
            }
        }
        
        
        for(int r=i,c = j ; r>=0 && c<board.length ; r--,c++){
            if( board[r][c] ){
                return false;
            }
        }
        
        return true;
    }
    
    private List<String> boardToList(boolean[][] b){
        
        List<String> ans = new ArrayList<>();
        for(int i=0 ; i<b.length ; i++){
            
            StringBuilder sb = new StringBuilder();
            
            for(int j=0 ; j<b.length ; j++){
                sb.append( b[i][j] ? 'Q' : '.' );    
            }
            ans.add(sb.toString());
        }
        
        return ans;
    }
    
    public void helper(int idx,boolean[][] board){
        
        if( idx == board.length ){
            
            Ans.add( boardToList(board) );
            return;
        }
        
        for(int c=0 ; c<board.length ; c++){
            
            if(  isValid( idx, c, board )  ){
                
                board[idx][c] = true;
                helper(idx+1, board);
                board[idx][c] = false;
            
            }            
        }
        
    }
    
    public List<List<String>> solveNQueens(int n) {
        
        helper(0, new boolean[n][n]);
        return Ans;
    }
}
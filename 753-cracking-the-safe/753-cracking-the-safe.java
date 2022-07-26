class Solution {
    
    StringBuilder sb = new StringBuilder();
    HashSet<String> set = new HashSet<>();
    public String crackSafe(int n, int k) {
        
        for(int i=0 ; i<n ; i++){
            sb.append('0');
        }
        set.add(sb.toString());
        
        int limit = (int)Math.pow(k,n); // k len pass 
        dfs( n,k, limit );
        return sb.toString();        
    }
    
    boolean dfs(int n, int k, int lim){
        
        if( set.size() == lim ){
            return true;
        }
        
        String prev = sb.substring( sb.length() - (n-1) );
        
        for( int i=0;  i<k ; i++ ){
            
            String newP = prev+i;
            if( !set.contains( newP ) ){
                
                set.add(newP);                
                sb.append(i);
                
                if( dfs( n,k,lim ) ){
                    return true;
                }
                set.remove(newP);
                sb.deleteCharAt( sb.length()-1 );
            }
            
        }
        return false;
    }
}
class Solution {
    
    
    
    public int longestValidParentheses(String s) {
     
        int[] dp = new int[s.length()];
        int max = 0, left = 0;
        for(int i=0 ; i<s.length() ; i++){
            
            char c = s.charAt(i);
            
            if( c=='(' )
                left++;
            else if( left > 0 ){            
                dp[i] = dp[i-1] + 2;
                dp[i] += i-dp[i]>=0 ? dp[ i-dp[i] ] : 0;
                max = Math.max(max, dp[i]);
                left--;
            }
        }
            
            
        return max;    
    }
    
    /*
    Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;
        for(int i=0 ; i<s.length() ; i++){
            
            char c = s.charAt(i);
            if( c==')' && st.size() > 1 && s.charAt( st.peek() ) == '('){
                    int j = st.pop();
                    max = Math.max( max, i-st.peek() );
                }
            else 
                st.push(i);                
            }
        return max;    
    */
}
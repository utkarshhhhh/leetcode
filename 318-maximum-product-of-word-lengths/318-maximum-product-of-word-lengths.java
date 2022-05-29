class Solution {
    
    private int convert(String s){
        
        int ans = 0;
        for(int i=0 ; i<s.length() ; i++){
            
            int c = s.charAt(i)-'a';
            ans |= (1<<c);
        }
        return ans;
    }
    
    public int maxProduct(String[] words) {
        
        int n = words.length, max = 0;
        int[] hash = new int[n];
        
        for(int i=0 ; i<n ; i++){
            hash[i] = convert(words[i]);
        }
        
        for(int i=0 ; i<n-1 ; i++){
            for(int j=1 ; j<n ; j++){
                if( (hash[i]&hash[j]) == 0 ){
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}
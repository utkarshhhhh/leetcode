class Solution {
    public int minPartitions(String n) {
     
        int ans = 0;
        for(int i=0 ; i<n.length() ; i++){
            ans = Math.max(ans, n.charAt(i));
            if(ans == 9) return 9;
        }
        return ans-'0';
    }
}
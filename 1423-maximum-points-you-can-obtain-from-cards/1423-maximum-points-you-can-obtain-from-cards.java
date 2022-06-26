class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        // find n-k min subarray
                
        int cur = 0, n = cardPoints.length;
        k = n-k;
        for(int left = 0 ; left<k ; left++ ){
            cur += cardPoints[left];
        }
        
        int ans = cur, sum = cur;
        
        for(int left = k, r = 0 ;  left<n ; left++, r++ ){
            
            cur += cardPoints[left];
            cur -= cardPoints[r];
            
            sum += cardPoints[left];
            
            ans = Math.min(ans, cur);        
        }
        
        return sum - ans;
    }
}
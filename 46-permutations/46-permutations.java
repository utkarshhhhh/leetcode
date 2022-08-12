class Solution {
    
    HashSet<List<Integer>> ans;
    
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void solve(int[] arr,int idx ){
        
        if( idx == arr.length){
            // System.out.println("here");
            List<Integer> cur = new ArrayList<>();
            for(int x : arr) cur.add(x);
            ans.add(cur);
            return;
        }
        
        for( int i = idx ; i < arr.length ; i++ ){            
            swap(arr,idx,i);
            solve(arr,idx+1);
            swap(arr,idx,i);            
        }
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        ans = new HashSet<>();
        solve(nums,0);
        return new ArrayList<>(ans);
    }
}
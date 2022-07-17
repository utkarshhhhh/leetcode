class Solution {
    
    ArrayList<Integer> ans = new ArrayList<>();
    ArrayList<Integer> sol = new ArrayList<>();
    
    public void helper(int cur, int[] arr, ArrayList<Integer> curAns, int n ){
        
        if( cur == (1<<n) -1 ){
            
            if( ans.size() == 0 || ans.size() > curAns.size() ){
                ans = new ArrayList<>( curAns );
            }
            return;
        }
        
        if( ans.size() != 0 && ans.size() <= curAns.size() )
         return ;  
        
        int lsb = find( cur );
        
        for(int i=0 ; i<arr.length ; i++){
            
            if( (arr[i]&(1<<lsb)) != 0 ){
                curAns.add(i);
                helper(cur|arr[i], arr, curAns, n );
                curAns.remove( curAns.size() -1 );    
            }            
        }   
    }
    
     public void search(int cur, int[] pe, List<Integer> onesol, int n) { 
        
         int zeroBit = 0;
        while (((cur>>zeroBit)&1) == 1) zeroBit++;   
        for (int i = 0; i < pe.length; i++) {
            int per = pe[i];
            if (((per>>zeroBit)&1) == 1) {
            }
        } 
    }
    
    int find(int req){
        
        int ans = 1;
        // 11010
        while( (req&1) == 1 ){            
            req >>= 1;
            ans++;            
        }
        return ans-1;
    }
    
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        HashMap<String, Integer> sk = new HashMap<>();
        
        int n = req_skills.length;
        for(int i=0 ; i<n ; i++)
            sk.put( req_skills[i] , i );
        
        int skillReq = (1<<n) -1;
        
        int[] peoples = new int[people.size()];
        
        for( int i=0 ; i<peoples.length ; i++ ){
            List<String> p = people.get(i);
            int cur = 0;
            for(String s : p){
                cur |= (1<<sk.get(s));
            }
            peoples[i] = cur;
        }
        
        // now i have people and req skill
        
        helper( 0, peoples, new ArrayList<>() , n);
        
        return ans.stream().mapToInt(i->i).toArray();
    }
}
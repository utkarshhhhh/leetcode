class Solution {
    
    HashMap<String, String> parent;
    HashMap<String, Double> mul;
        
    public void inGraph(String s){        
        parent.put( s,s );
        mul.put( s, 1.0 );
    }
    
    public String find(String s){
        if( parent.get(s).equals(s) ) return s;
        
        String curPar = parent.get(s);
        String findPar = find(curPar);
        
        // mul
        
        mul.put( s, mul.get(s)*mul.get(curPar) );
        
        parent.put( s, findPar );
        return findPar;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        parent = new HashMap<>();
        mul = new HashMap<>();

        for(List<String> eq : equations){
            inGraph( eq.get(0) );
            inGraph( eq.get(1) );
        }
        
        // union
        int i=0;
        for(List<String> eq : equations){
            String s1 = eq.get(0) ;
            String s2 = eq.get(1) ;
            
            String l1 =  find(s1); // lead1
            String l2 =  find(s2); // lead2
            
            Double d1 = mul.get(s1);
            Double d2 = mul.get(s2);
            
            mul.put( l1, d2*values[i]/d1 );
            parent.put(l1, l2);
            i++;
        }
        
        double[] ans = new double[ queries.size() ];
        i=0;
        for( List<String> l : queries ){
            
            String s1 = l.get(0) ;
            String s2 = l.get(1) ;
            
            if( !parent.containsKey(s1) || !parent.containsKey(s2) ){
                ans[i] = -1.0;
                i++;
                continue;
            }
            
            String l1 =  find(s1); // lead1
            String l2 =  find(s2); // lead2
            
            if( !l1.equals(l2) ){
                ans[i] = -1.0;
                i++;
                continue;
            }
            
            Double d1 = mul.get(s1);
            Double d2 = mul.get(s2);
            
            ans[i] = d1/d2;
            i++;
        }
        return ans;
    }
}
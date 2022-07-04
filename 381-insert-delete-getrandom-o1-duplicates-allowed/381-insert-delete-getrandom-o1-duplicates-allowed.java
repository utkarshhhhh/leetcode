class RandomizedCollection {

    HashMap<Integer, HashSet<Integer>> map ;
    ArrayList<Integer> arr ;
    java.util.Random rand = new java.util.Random();
    
    public RandomizedCollection() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if( !map.containsKey(val) )
            map.put( val, new HashSet<>() );
        map.get(val).add( arr.size() );
        arr.add( val );
        return map.get(val).size()==1;
    }
    
    public boolean remove(int val) {
        
        if( !map.containsKey(val) || map.get(val).size() == 0 ) return false;
        
        int idx1 = map.get(val).iterator().next();
        int idx2 = arr.size()-1;
        
        int num = arr.get(idx2);
        arr.set( idx1, num );
        
        map.get( val ).remove( idx1 );
        map.get( num ).add( idx1 );
        map.get( num ).remove( idx2 );
        
        arr.remove( idx2 );
        return true;
    }
    
    public int getRandom() {
        return arr.get( rand.nextInt( arr.size() ) );
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
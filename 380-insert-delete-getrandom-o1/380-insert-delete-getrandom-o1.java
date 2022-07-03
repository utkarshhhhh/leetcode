class RandomizedSet {
    java.util.Random rand = new java.util.Random();

    HashMap<Integer, Integer> map;
    ArrayList<Integer> arr;
    
    public RandomizedSet() {
    
        map = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        
        if( map.containsKey( val ) ) return false;
        
        map.put( val, arr.size() );
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        
        if( !map.containsKey(val) ) return false;
        int idx1 = map.get(val);
        int idx2 =  arr.size()-1 ;
        
        if( idx1 < idx2 ){
            arr.set( idx1, arr.get(idx2) );
            map.put( arr.get( idx1 ), idx1 );
        }
        arr.remove( idx2 );
        map.remove( val );
        
        return true;
    }
    
    public int getRandom() {
        return arr.get( rand.nextInt( arr.size() ) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
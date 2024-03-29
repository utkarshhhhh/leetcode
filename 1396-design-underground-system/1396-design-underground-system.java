class UndergroundSystem {

    Map<Integer, Pair<String , Integer>> checkInMap; // id , station , checkintime
    Map<String, Pair<Double , Integer>> routeMap;  // routename , time , count
    
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put( id , new Pair<>( stationName , t ) );
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String , Integer> checkIn = checkInMap.get(id) ;
        checkInMap.remove(id);
        
        String routeName = checkIn.getKey() + "_" + stationName ; 
        int totalTime = t - checkIn.getValue();
        
        Pair<Double , Integer> route = routeMap.getOrDefault( routeName , new Pair<>( 0.0 , 0 ) );
        routeMap.put(routeName , new Pair<>( route.getKey() + totalTime , route.getValue() + 1 ) );
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        Pair<Double , Integer> route = routeMap.get( startStation + "_" + endStation );
        
        return route.getKey()/route.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
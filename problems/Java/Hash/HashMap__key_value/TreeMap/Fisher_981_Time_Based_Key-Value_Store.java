
//https://www.youtube.com/watch?v=eVi4gDimCoo
//LeetCode 981. Time Based Key-Value Store - Interview Prep Ep 107
//https://leetcode.com/problems/time-based-key-value-store/

class TimeMap {
	
	//TreeMap 
	//https://www.geeksforgeeks.org/treemap-in-java/
	// TreeMap are always sorted based on the natural ordering of the keys
	Map<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
			map.put(key, new TreeMap());
		}
		TreeMap<Integer, String> timeMap = map.get(key);
		timeMap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeMap = map.get(key);
		// https://www.geeksforgeeks.org/treemap-floorkey-in-java-with-examples/
		// return the greatest key less than or equal to given key from the parameter.
		Integer prevTime = timeMap.floorKey(timestamp);
		if(prevTime == null){
			return "";
		} else {
			return timeMap.get(prevTime);
		}
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 
 Input: inputs = ["TimeMap","set","set","get","get","get","get","get"], 
 inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
Output: [null,null,null,"","high","high","low","low"]
 */



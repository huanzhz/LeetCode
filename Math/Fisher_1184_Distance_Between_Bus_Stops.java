
//https://www.youtube.com/watch?v=RFq7yA5iyhI
//LeetCode 1184: Distance Between Bus Stops - Interview Prep Ep 15
//https://leetcode.com/problems/distance-between-bus-stops/

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start > destination){
			int tmp = start;
			start = destination;
			destination = tmp;
		}
		int oneWay = 0;
		for(int i = start; i < destination; i++){
			oneWay += distance[i];
		}
		int otherWay = 0;
		for(int i = destination; i < distance.length; i++){
			otherWay += distance[i];
		}
		for(int i = 0; i < start; i++){
			otherWay += distance[i];
		}
		return Math.min(oneWay, otherWay);
    }
}

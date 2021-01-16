
//https://www.youtube.com/watch?v=leiSa1i-QrI
//LeetCode 781. Rabbits in Forest - Interview Prep Ep 106
//https://leetcode.com/problems/rabbits-in-forest/

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap();
		int rabbits = 0;
		for(int rabbit : answers){
			// if encounter same type of rabbit
			if(map.containsKey(rabbit)){
				// get the limit of the type for the rabbit
				int quota = map.get(rabbit);
				quota--;
				if(quota == 0){
					// remove the type rabbit
					map.remove(rabbit);
				} else {
					// update the map
					map.put(rabbit, quota);
				}
			} else {
				// if the rabbit is first time encounter
				rabbits += rabbit;
				rabbits++;
				// type 0 rabbit 
				if(rabbit != 0){
					map.put(rabbit, rabbit);
				}
			}
		}
		return rabbits;
    }
}



//https://www.youtube.com/watch?v=wGgcRCpSAa8
//LeetCode 1282: Group the People Given the Group Size They Belong To - Interview Prep Ep 24
//https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

class Solution {
	
	//[3,3,3,3,3,1,3]
	//map:
	//		key: 3 -> 0, 1, 2, 3, 4, 6
	//		key: 1 -> 5
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap();
		for(int i = 0; i < groupSizes.length; i++){
			// get the list whether it initialise before or create a new arraylist for it
			List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList());
			list.add(i);
			// update the map
			map.put(groupSizes[i], list);
		}
		List<List<Integer>> result = new ArrayList();
		// https://www.geeksforgeeks.org/hashmap-keyset-method-in-java/
		// keyset -> get the value of the hashmap <value, key>
		for(int key: map.keySet()){
			int i = 0;
			List<Integer> list = map.get(key);
			do{
				// https://www.geeksforgeeks.org/arraylist-sublist-method-in-java-with-examples/
				// Original arrlist: [A, B, C, D, E]
				// Sublist of arrlist: [C, D]
				// public List subList(int fromIndex, int toIndex)
				result.add(list.subList(i, i + key));
				i += key;
			}while(i + key <= list.size());
		}
		return result;
    }
}


//https://www.youtube.com/watch?v=TqKDnzkRsh0
//LeetCode 1620. Coordinate With Maximum Network Quality - Interview Prep Ep 98
//https://leetcode.com/problems/coordinate-with-maximum-network-quality/

// solution -> https://leetcode.com/problems/coordinate-with-maximum-network-quality/discuss/943751/Clean-Java-Code!
// Question not clear, because it never specific the tower or coordinates 
// below code is to find out the best tower but not the best coordinates
class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] best = new int[2];
		int maxSignal = 0;
		for(int i = 0; i < towers.length; i++){
			int thisQuality = 0;
			for(int j = 0; j < towers.length; j++){
				//Euclidean distance
				double distance = Math.sqrt((towers[i][0] - towers[j][0]) * (towers[i][0] - towers[j][0]) 
				+(towers[i][1] - towers[j][1]) * (towers[i][1] - towers[j][1]));
				if(distance <= radius){
					thisQuality += Math.floor(towers[j][2]/(1 + distance));
				}
			}
			if(thisQuality > maxSignal){
				maxSignal = thisQuality;
				best[0] = towers[i][0];
				best[1] = towers[i][1];
			} else if(thisQuality == maxSignal){
				if(towers[i][0] < best[0]){
					best[0] = towers[i][0];
					best[1] = towers[i][1];
				} else if(towers[i][0] == best[0] && towers[i][1] < best[1]){
					best[0] = towers[i][0];
					best[1] = towers[i][1];
				}
			}
		}	
		return best;
    }
}

/*
Input: towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
Output: [2,1]
Input: towers = [[23,11,21]], radius = 9
Output: [23,11]
Input: towers = [[1,2,13],[2,1,7],[0,1,9]], radius = 2
Output: [1,2]
Input: towers = [[2,1,9],[0,1,9]], radius = 2
Output: [0,1]
*/



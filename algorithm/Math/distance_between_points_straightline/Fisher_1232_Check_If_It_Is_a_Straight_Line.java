
//https://www.youtube.com/watch?v=_tfiTQNZCbs
//LeetCode 1232: Check If It Is a Straight Line - Interview Prep Ep 30
//https://leetcode.com/problems/check-if-it-is-a-straight-line/

// slope: K1(p1,p2) = (y2-y1)/(x2-x1)
// slope: K2(p1,p3) = (y3-y1)/(x3-x1)
// check whether K1 equals to K2
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        for(int i = 2; i < coordinates.length; i++){
			if((coordinates[1][1] - coordinates[0][1]) * (coordinates[i][0] - coordinates[0][0]) !=
			(coordinates[1][0] - coordinates[0][0]) * (coordinates[i][1] - coordinates[0][1])){
				return false;
			}
		}
		return true;
    }
}

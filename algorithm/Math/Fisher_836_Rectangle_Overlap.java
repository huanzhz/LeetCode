
//https://www.youtube.com/watch?v=o6hHUk4DOW0
//LeetCode 836: Rectangle Overlap - Interview Prep Ep 44
//https://leetcode.com/problems/rectangle-overlap/

//This solution does not check for not rectangle but cover all case of overlap
//[left_bottom, right_bottom, top_left, top_right]
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //x-axis: 0, 2
		//y-axis: 1, 3
		//left1 < right2 && left2 < right1
		return
			//for x-axis
			rec1[0] < rec2[2] && rec2[0] < rec1[2]
			&&
			//for y-axis
			rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }
}

//https://leetcode.com/problems/rectangle-overlap/discuss/928972/straight-forward-math-solution-Java-100
//https://leetcode.com/Byte_Me_/
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // no lines:
        // if any of the rec1 or rec2 are not rectangular 
        // return false directly:
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || 
           rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }
        // if both are rectagular:
        if ((rec1[2] > rec2[0] && rec1[3] > rec2[1] && rec1[0] < rec2[2] && rec1[1] < rec2[3]) ||
           (rec1[2] < rec2[0] && rec1[3] < rec2[1] && rec1[0] > rec2[2] && rec1[1] > rec2[3])
           ) {
            return true;
        }
        return false;
    }
}
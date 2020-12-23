
//https://leetcode.com/problems/coordinate-with-maximum-network-quality/discuss/943751/Clean-Java-Code!

class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int res[] = new int[2];
        double maxQuality = 0;
        double quality = 0;
        int finalX = 0;
        int finalY = 0;
		// loop through the 51 by 51 coordinates 
        for(int i=0; i<51; i++) {
            for(int j=0; j<51; j++) {
                quality = 0;
				// find our which coordinates has the best quality amongest the towers 
                for(int[] tower: towers) {
                    int x = tower[0]-i;
                    int y = tower[1]-j;
                    double dist = Math.sqrt(x*x+y*y); 
                    if(dist <= radius) quality += Math.floor(tower[2]/(1+dist));
                }
                if(maxQuality < quality) {
                    maxQuality = quality;
                    finalX = i;
                    finalY = j;
                }
            }
        }
        res[0] = finalX;
        res[1] = finalY;
        return res;
    }
}

//https://www.youtube.com/watch?v=rk-aB4rEOyU
//LeetCode 1138. Alphabet Board Path - Interview Prep Ep 105
//https://leetcode.com/problems/alphabet-board-path/

class Solution{
	public String alphabetBoardPath(String target){
		Map<Character, int[]> map = initMap();
		StringBuilder strBuilder = new StringBuilder();
		int[] currPos = new int[2];
		// string to char array
		for(char c : target.toCharArray()){
			moveToDest(currPos, map.get(c), strBuilder);
		}
		return strBuilder.toString();
	}
	
	// Up, Right, Left, Down
	private void moveToDest(int[] currPos, int[] dest, StringBuilder strBuilder){
		int currRow = currPos[0];
		int currCol = currPos[1];
		int destRow = dest[0];
		int destCol = dest[1];
		// keep looping to find the destination
		while(currRow != destRow || currCol != destCol){
			// keep moving down
			if(currRow < destRow){
				while(currRow < destRow){
					// corner case 'z'
					if( currCol != 0 && currRow == 4){
						break;
					}
					strBuilder.append("D");
					currRow++;
				}
				currPos[0] = currRow;
			}
			// keep going up
			if(currRow > destRow){
				while(currRow > destRow){
					strBuilder.append("U");
					currRow--;
				}
				currPos[0] = currRow;
			}
			// keep going right
			if(currCol < destCol){
				while(currCol < destCol){
					strBuilder.append("R");
					currCol++;
				}
				currPos[1] = currCol;
			}
			// keep going left
			if(currCol > destCol){
				while(currCol > destCol){
					strBuilder.append("L");
					currCol--;
				}
				currPos[1] = currCol;
			}
		}
		// Found the destination add "!"
		strBuilder.append("!");
		return;
	}
	
	// initialise the hashmap
	private Map<Character, int[]> initMap(){
		// hashmap , key->value or dictionary
		//How HashMap works in Java? With Animation!! whats new in java8 tutorial
		//https://www.youtube.com/watch?v=c3RVW3KGIIE
		Map<Character, int[]> map = new HashMap();
		int row;
		int col;
		int number = 0;
		for (char c = 'a'; c<= 'z'; c++, number++){
			// 0,1,2,3,4 divide by 5 give 0 
			row = number / 5;
			// 0 % 5 = 0
			// 1 % 5 = 1
			// 2 % 5 = 2
			// 3 % 5 = 3
			// 4 % 5 = 4
			col = number % 5;
			// add to the map
			map.put(c, new int[]{row, col});
		}
		return map;
	}
}











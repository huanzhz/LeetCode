
//https://www.youtube.com/watch?v=mQQp6I985bw
//LeetCode 957. Prison Cells After N Days - Interview Prep Ep 81
//https://leetcode.com/problems/prison-cells-after-n-days/

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
		// Detect cycle
		Set<String> set = new HashSet();
		boolean hasCycle = false;
		int days = 0;
		for(int i = 0; i < N; i++){
			int[] next = getNext(cells);
			String str = Arrays.toString(next);
			// if there is no such set, add the set
			if(!set.contains(str)){
				set.add(str);
				days++;
			} else {
				hasCycle = true;
				break;
			}
			cells = next;
		}
		
		if(hasCycle){
			N %= days;
			for(int i = 0; i < N; i++){
				cells = getNext(cells);
			}
		}
		return cells;
    }
	
	private int[] getNext(int[] cells){
		int[] next = new int[cells.length];
		for(int i = 0; i < cells.length; i++){
			// first and last cell
			if(i == 0 || i == cells.length - 1){
				next[i] = 0;
			} else {
				// if cell is equal return 1 else return 0
				next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
			}
		}
		return next;
	}
}

/*
Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
*/
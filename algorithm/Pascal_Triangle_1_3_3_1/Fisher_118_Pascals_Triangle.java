
//https://www.youtube.com/watch?v=TXd5lfP3Gac
//LeetCode 118: Pascal's Triangle - Interview Prep Ep 34
//https://leetcode.com/problems/pascals-triangle-ii/

// 1 1 1 
// 1 2 1 

// 1 1 2 1
// 1 3 3 1

//old 
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList();
		List<Integer> row = new ArrayList();
		for(int i = 0; i < k; i++){
			row.add(0, 1);
			for(int j = 1; j < row.size() - 1; j++){
				row.set(j, row.get(j) + row.get(j + 1));
			}
			result.add(new ArrayList(row));
		}
		return result;
    }
}

//new it doesnt count the first layer hence i = -1
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList();
		List<Integer> row = new ArrayList();
		for(int i = -1; i < rowIndex; i++){
			row.add(0, 1);
			// add up the two number
			for(int j = 1; j < row.size() - 1; j++){
				// https://beginnersbook.com/2013/12/java-arraylist-set-method-example/
				// set(column, value)
				row.set(j, row.get(j) + row.get(j + 1));
			}
			// add into the array
			result.add(new ArrayList(row));
		}
		// https://stackoverflow.com/questions/687833/how-to-get-the-last-value-of-an-arraylist
		return result.get(result.size() - 1);
    }
}
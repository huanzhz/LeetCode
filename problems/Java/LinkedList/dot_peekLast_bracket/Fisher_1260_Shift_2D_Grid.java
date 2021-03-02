
//https://www.youtube.com/watch?v=9hBcARSiU0s
//LeetCode 1260: Shift 2D Grid - Interview Prep Ep 12
//https://leetcode.com/problems/shift-2d-grid/

/*
    flatten 2d to 1d
    k % (m * n) = 10 % (3 * 3) = 1
    k = 10 is equivalent to k = 1

    m = 3;
    n = 3;
    grid[0][1] = 2
    i * n + j = 0 * 3 + 1 = 1
    grid[2][2] = 9
    i * n + j = 2 * 3 + 2 = 6 + 2 = 8
*/

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // get the grid row and column length
        // m = row, n = column
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        // reduce looping twice or more
        int start = total - k % total;
        LinkedList<List<Integer>> result = new LinkedList();
        for(int i = start; i < total + start; i++){
            int moveIndex = i % total;
            int moveRow = moveIndex / n;
            int moveColumn = moveIndex % n;
            if((i - start) % n == 0){
                result.add(new ArrayList());
            }
            // peekLast get the last elment of the array
            // https://www.tutorialspoint.com/java/util/linkedlist_peeklast.htm
            // able to use this because final output is 1D array
            result.peekLast().add(grid[moveRow][moveColumn]);
        }
        return result;
    }
}


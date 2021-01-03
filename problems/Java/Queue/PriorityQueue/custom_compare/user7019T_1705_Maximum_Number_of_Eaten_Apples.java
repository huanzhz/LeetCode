
//https://leetcode.com/contest/weekly-contest-221/problems/maximum-number-of-eaten-apples/
//https://leetcode.com/problems/maximum-number-of-eaten-apples/discuss/996144/My-Java-solution-using-PriorityQueue

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
		int amount_of_apple_ate = 0;
		// initialise the priorityQueue
		// custom ordering
		// https://www.freecodecamp.org/news/priority-queue-implementation-in-java/
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
			// https://www.geeksforgeeks.org/java-integer-compare-method/
			/*
			Return :
				This method returns the value zero if (x==y), 
				if (x < y) then it returns a value less than zero 
				and if (x > y) then it returns a value greater than zero.
			*/
			// compare the day of rotten 
            return Integer.compare(a[1], b[1]);
        });

		for (int i = 0; ; i++) {
			//  offer​(E e)	Inserts the specified element into this priority queue.
			// https://www.geeksforgeeks.org/priorityqueue-offer-method-in-java/
			// if there is still apple and not rotten
            if (i < n && apples[i] != 0) {
				// add the apple to the queue
				q.offer(new int[]{apples[i], i+days[i]});
			}
			// remove rotten apples in the queue
			// peek()	Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
            while (!q.isEmpty() && q.peek()[1] <= i){
				// poll()	Retrieves and removes the head of this queue, or returns null if this queue is empty.
				q.poll();
			}
			// reach the end of days
            if ( i >= n && q.isEmpty()){
				break;
			}
			
            if (!q.isEmpty()) {
				// minus 1 apple in the queue and check if there is no apples left
                if(--q.peek()[0] == 0) {
					// remove the apple from queue if there is no more apple left there
					q.poll();
				}
				// increase the apple ate
                amount_of_apple_ate++;     
            }
        }
        return amount_of_apple_ate;
    }
}

/*
Input: apples = [1,2,3,5,2], days = [3,2,1,4,2]
Output: 7
Input: apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
Output: 5
*/


//https://www.youtube.com/watch?v=spiwTAuz1_4
//LeetCode 1005: Maximize Sum Of Array After K Negations - Interview Prep Ep 38
//https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue();
		// add time into the queue
		for(int num : A){
			heap.offer(num);
		}
		// number of negation, add the first queue and negate it, as it is acending order
		while(K-- > 0){
			heap.offer(-heap.poll());
		}
		// add all the numbers together
		int sum = 0;
		while(!heap.isEmpty()){
			sum += heap.poll();
		}
		return sum;
    }
}


class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
		Arrays.sort(A);
		for (int i = 0; i < A.length && K > 0 && A[i] < 0; i++, K--){
			A[i] = -A[i];
		}
		int min = A[0];
		int sum = 0;
		for (int num : A){
			sum += num;
			min = Math.min(min, num);
		}
		return K % 2 == 0 ? sum : sum - 2 * min;
	}
}





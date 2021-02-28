
//https://www.youtube.com/watch?v=MQ2i4T1l-G
//LeetCode 1243: Array Transformation - Interview Prep Ep 14
//https://leetcode.com/problems/array-transformation/
//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_1243.java

/*
[6, 2, 3, 4]
Output [6, 3, 3, 4]

1, 6, 3, 4, 3, 5]
Output 
[1, 5, 4, 3, 4, 5]
[1, 4, 4, 4, 4, 5]
if greater than both left right decrease by 1
*/
public static class Solution1 {
	public List<Integer> transformArray(int[] arr) {
		int[] copy;
		do {
			copy = Arrays.copyOf(arr, arr.length);
			for (int i = 1; i < arr.length - 1; i++) {
				if (copy[i] < copy[i - 1] && copy[i] < copy[i + 1]) {
					arr[i]++;
				} else if (copy[i] > copy[i - 1] && copy[i] > copy[i + 1]) {
					arr[i]--;
				}
			}
		} while (!Arrays.equals(copy, arr));
		// boxed
		// https://howtodoinjava.com/java8/java8-boxed-intstream/
		// stream -> remove heavy lifting
		// https://www.youtube.com/watch?v=FWoYpM-E3EQ
		return Arrays.stream(arr)
				.boxed()
				.collect(Collectors.toList());
	}
}
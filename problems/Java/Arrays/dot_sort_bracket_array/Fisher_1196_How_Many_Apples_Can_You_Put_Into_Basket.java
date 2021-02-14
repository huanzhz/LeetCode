
//https://www.youtube.com/watch?v=UelshlMQNJM
//LeetCode 1196: How Many Apples Can You Put into Basket - Interview Prep Ep 29
//https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/
//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_1196.java

public int maxNumberOfApples(int[] arr) {
	Arrays.sort(arr);
	int sum = 0;
	int i = 0;
	for (; i < arr.length; i++) {
		sum += arr[i];
		if (sum > 5000) {
			break;
		}
	}
	return i;
}



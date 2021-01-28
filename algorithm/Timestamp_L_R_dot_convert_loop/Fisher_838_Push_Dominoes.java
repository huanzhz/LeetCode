
//https://www.youtube.com/watch?v=0_XmKkgHSdI
//LeetCode 838. Push Dominoes - Interview Prep Ep 108
//https://leetcode.com/problems/push-dominoes/

class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder currentSb = new StringBuilder(dominoes);
		Set<String> set = new HashSet();
		set.add(dominoes);
		do{
			StringBuilder newSb = new StringBuilder();
			// check the left right neighbour
			for(int i = 0; i < currentSb.length(); i++){
				if(currentSb.charAt(i) == 'L'){
					newSb.append('L');
					if(i == 1 && currentSb.charAt(0) == '.'){
						newSb.replace(i - 1, i, "L");
					} else if ( i > 1 && currentSb.charAt(i - 1) == '.' && currentSb.charAt(i - 2) != 'R'){
						newSb.replace(i - 1, i, "L");
					}
				} else if(currentSb.charAt(i) == 'R'){
					newSb.append('R');
					if(i == currentSb.length() - 2 && currentSb.charAt(i + 1) == '.'){
						newSb.replace(i + 1, i+2, "R");
						i++;
					} else if ( i < currentSb.length() - 2 && currentSb.charAt(i + 1) == '.' && currentSb.charAt(i + 2) != 'L'){
						newSb.replace(i + 1, i+2, "R");
						i++;
					}
				} else {
					newSb.append('.');
				}
			}
			// empty the string for new string
			currentSb.setLength(0);
			// change to the new string where L and R converted
			currentSb = newSb;
		}while(set.add(currentSb.toString()));
		// it break when there is not more L or R convert
		return currentSb.toString();
    }
}










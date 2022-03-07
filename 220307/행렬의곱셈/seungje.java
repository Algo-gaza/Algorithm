class Solution {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		int i1 = 0, i2 = 0;
		for (int i = 0; i < arr1.length; i++) {
			int test = 0;
			while (test < arr2[0].length) {
				for (int j = 0; j < arr2.length; j++) {
					answer[i1][i2] += arr1[i][j] * arr2[j][test];
				}
				test++;
				i2++;
				if (i2 == arr2[0].length) {
					i2 = 0;
					i1++;
				}
			}
		}
		return answer;
	}
}

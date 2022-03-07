class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int sum = 0;
/*      
        1, 3    3, 3    1*3+3*3 1*3+3*3
        3, 2    3, 3    3*3+2*3 3*3+2*3
        4, 1            4*3+1*3 4*3+1*3
arr1.length = 3
arr1[0].length = 2
*/
/*
        2 3 2   5 4 3   2*5+3*2+2*3 2*4+3*4+2*1 2*3+3*1+2*1
        4 2 4   2 4 1   4*5+2*2+4*3 4*4+2*4+4*1 4*3+2*1+4*1
        3 1 4   3 1 1   3*5+1*2+4*3 3*4+1*4+4*1 3*3+1*1+4*1
arr1.length = 3
arr1[0].length = 3
*/
        for(int i = 0; i < arr1.length; i++){
            for(int k = 0; k < arr2[0].length; k++){
                for(int j = 0; j < arr1[0].length; j++){
                    sum += arr1[i][j] * arr2[j][k];
                }
                answer[i][k] = sum;
                sum = 0;
            }
        }
        return answer;
    }
}

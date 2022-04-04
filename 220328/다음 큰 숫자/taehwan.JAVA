class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = n + 1; ; i++){
            if(countOnes(i) == countOnes(n)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public int countOnes(int n){
        int count = 0;
        while(n > 0){
            if(n % 2 != 0)
                count++;
            n /= 2;
        }
        return count;
    }
}

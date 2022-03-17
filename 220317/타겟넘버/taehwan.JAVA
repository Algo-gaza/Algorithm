class Solution {
    int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
				//깊이 우선 탐색을 실시, 깊이는 0부터 시작, 합계는 아직 0이므로 0 전달
        return cnt;
    }
    public void dfs(int[] numbers, int target, int depth, int result){
		//numbers 배열을 탐색, target에 도달할 때까지 탐색,
		//어느 깊이까지 도달했는지 depth, 깊이 우선 탐색을 하며 합한 결과값

        if(depth == numbers.length){
				//numbers 배열의 마지막까지 탐색을 했어?
            if(result == target){
						//결과값과 타겟넘버가 같아?
                cnt++;
								//그럼 개수 +1
            }
        }
        else{
				//아직이면 더 돌려
				//ex) 4 + 1 ...
            dfs(numbers, target, depth + 1, result + numbers[depth]);
						//방금 탐색한 숫자를 더했을 때 이후 탐색
						//ex) 4 + 1 + 2 ...
            dfs(numbers, target, depth + 1, result - numbers[depth]);
						//방금 탐색한 숫자를 뺐을 때 이후 탐색
						//ex) 4 + 1 - 2 ...
        }
    }
}

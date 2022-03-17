class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        int sum = 0;
        
        for(int i : numbers) 
            sum+=i;
        
        for(int i=1; i<numbers.length-1; i++) 
            comb(numbers, new boolean[numbers.length], 0, numbers.length, i, sum, target);
        
        return answer;
    }

    public void comb(int[] numbers, boolean[] visited, int start, int n, int r, int sum, int target) {
	    if(r == 0) {
	    	int test = sum;
	    	for(int i =0 ; i < visited.length; i++) 
	    		if(visited[i]) 
                    test += numbers[i] * -2;
	    	if(test==target) answer++;
	        return;
	    } 
	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        comb(numbers, visited, i + 1, n, r - 1,sum,target);
	        visited[i] = false;
	    }
	}
}

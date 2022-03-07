import java.util.ArrayList;
import java.util.List;

class Solution {
	static List<Integer> list = new ArrayList<>();
	static int answer = 0;
    public static int solution(String numbers) {
        int[] arr = new int[numbers.length()];
        int[] output = new int[arr.length];
        boolean[] visited = new boolean[arr.length];
        String[] s_arr = numbers.split("");
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(s_arr[i]);
        }
        for(int i=1; i<=arr.length; i++) {
            perm(arr, output, visited, 0, arr.length, i);
        }
        return answer;
    }
    
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
            String s = "";
			for (int i = 0; i < r; i++) {
                s += String.valueOf(output[i]);
			}
			if(s.equals("0")) return;
            while(s.indexOf('0')==0) {
                s = s.replaceFirst("0", "");
            }
            if(s.equals("1")||s.equals("")) return;
            if(prime(Integer.parseInt(s))) answer++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}
    static boolean prime(int n) {
    	if(n==1||list.contains(n)) return false;
    	list.add(n);
        boolean b=false;
        for(int i=2; i<n; i++) {
            if(n%i==0) {
                b=true;
                break;
            }
        }
        return (b==false) ? true : false;
    }
}

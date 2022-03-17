import java.util.ArrayList;

class Solution {
    int answer = 0;
    boolean[] flag = new boolean[7];
    ArrayList<Integer> num = new ArrayList<Integer>();
    
    public void combination(String numbers, String temp, int numLength){
        if(temp.length() == numLength){
            if(!num.contains(Integer.parseInt(temp)))
                num.add(Integer.parseInt(temp));
        }
        for(int i = 0; i < numbers.length(); i++){
            if(flag[i])
                continue;
            temp += numbers.charAt(i);
            flag[i] = true;
            combination(numbers, temp, numLength);
            flag[i] = false;
            temp = temp.substring(0, temp.length() - 1);
        }
    }
    
    public boolean isPrime(int n){
        if(n == 0) return false;
        if(n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        String temp = "";
        for(int i = 1; i <= numbers.length(); i++){
            combination(numbers, temp, i);
        }
        for(int i = 0; i < num.size(); i++){
            if(isPrime(num.get(i)))
                answer++;
        }
        return answer;
    }
}

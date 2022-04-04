class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.toLowerCase().split("");
        
        boolean first = true;
        for(int i = 0; i < arr.length; i++) {
            if(first)
                answer += arr[i].toUpperCase();
            else
                answer += arr[i];
            if(arr[i].equals(" "))
                first = true;
            else
                first = false;          
        }
        return answer;
    }
}

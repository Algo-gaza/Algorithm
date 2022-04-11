import java.util.*;

class Solution {
	
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE, temp=0;
        for(int i=1; i<=s.length(); i++) {
            temp = compression(s, i);
            if(answer > temp) answer = temp;
        }
        return answer;
    }
    
    public static int compression(String s, int n) {
        List<String> list = new ArrayList<>();
        
        int i;
        
        for(i=0; i<s.length(); i+=n) {
            list.add(s.substring(i, i+n));
        }
        if(i != s.length()) list.add(s.substring(i-n, s.length()));
        
        int count=0;
        for(i=0; i<list.size()-1; i++) {
            if(list.get(i).equals(list.get(i+1))) {
                list.remove(i+1); count++; i--;
            }
            else {
                if(count==0)
                    continue;
                else {
                    list.add(i, String.valueOf(count));
                    count=0;
                }
            }
        }
        int answer=0;
        for(String s1 : list) 
            answer += s1.length();
        return answer;
    }
}

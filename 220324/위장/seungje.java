import java.util.*;
class Solution {
    static int answer = 1;
    static Map<String, Integer> map = new HashMap<>();
    public static int solution(String[][] clothes) {
        
        for(int i=0; i<clothes.length; i++) 
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        
        for(String s : map.keySet()) {
            answer*=(map.get(s)+1);
        }
        
        return answer - 1;
    }
}

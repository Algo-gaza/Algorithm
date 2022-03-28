import java.util.*;
class Solution {
    public List<Integer> solution(String s) {
        StringTokenizer st = new StringTokenizer(s, "{,}");
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
      
        while(st.hasMoreTokens()) {
            int t = Integer.parseInt(st.nextToken());
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
      
        for(Integer i : map.keySet()) 
            map2.put(map.get(i), i);
      
        for(int i=map.size(); i>=1; i--) 
            list.add(map2.get(i));
      
        return list;
    }
}

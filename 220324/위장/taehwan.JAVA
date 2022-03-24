import java.util.HashMap;
class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            //clothes[i][1]은 옷 종류
            if(!map.containsKey(clothes[i][1])) {
            //map에 그 종류가 없다면 추가해
                map.put(clothes[i][1], 1);
            } else {
            //map에 그 종류가 이미 있으면 개수 +1로 덮어쓰기
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
        }
        
        for (int i = 0; i < clothes.length; i++){
            //입을 수 있는 옷의 조합의 경우의 수(곱하기)
            answer *= (map.get(clothes[i][1]) + 1); //+1은 그 옷만 입었을 경우도 포함하고 있음
            map.put(clothes[i][1], 0);  //입었으면 0으로 초기화하여 중복 방지
        }

        return answer - 1;  //모두 안 입었을 경우 1 제외
    }
}

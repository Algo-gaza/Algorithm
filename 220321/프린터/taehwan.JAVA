import java.util.LinkedList;
import java.util.Queue;

class Print{
    int priorities;
    int location;
    public Print(int p, int l){
        this.priorities = p;    //순위 값
        this.location = l;      //원래 있던 위치(인덱스) 값
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> q = new LinkedList<>();
        boolean check = false;  //순위 비교용
        int cnt = 0;   //프린트 횟수
        
        for(int i = 0; i < priorities.length; i++){
            q.add(new Print(priorities[i], i));
        }
        
        for(Print comparison : q){
            System.out.println("C: " + comparison.location);
        }
        while(!q.isEmpty()){
            Print temp = q.poll();  //1번 작업 수행
            check = false;
            for(Print comparison : q){
                if(comparison.priorities > temp.priorities){
                    check = true;
                    break;
                }
            }
            if(check){  //더 높은 순위가 있으니 2번 작업 수행
                q.add(temp);
            }
            else{
                cnt++;
                if(temp.location == location){   //단순 순위가 똑같은 애가 아닌 본인이 맞다면 3번 작업 수행
                    answer = cnt;
                    break;
                }
            }
        }
        return answer;
    }
}

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();  //배포 전 작업들
        ArrayList<Integer> completion = new ArrayList<Integer>();   //배포 시 완려되는 기능 개수
                
        for(int i = 0; i < progresses.length; i++){
            queue.add(progresses[i]);
        }
        
        int cnt = 0;
				//작업을 진행한 일 수, 진행된 %를 구하기 위함
				//speeds[j] * cnt 를 통해 구함

        int j = 0;
	      //한 작업이 끝나면 다음 작업으로 넘어감을 표현하기 위한 인덱스값
				//speeds[j], j++ 를 통해 구함

        int pollCount = 0;
				//배포 시(같은 날) 작업이 완료되는 기능 개수를 구하기 위함
				//queue.poll() 을 통해 큐에서 출력된 작업은 완료된 것으로 간주

				while(!queue.isEmpty()){
            cnt++;
            if((queue.peek() + speeds[j] * cnt) >= 100){
						//작업이 완료될만큼의 일 수가 지났다면
                queue.poll();
                pollCount++;
                j++;   //앞 작업이 완료됐으면 뒷작업으로 넘어가자
                cnt--; //앞 작업이 완료되기 이전에 이미 뒷순서 작업들이 완료됐을 수도 있으니
                if(queue.isEmpty()){
								//마지막 작업이 완료돼서 큐에서 빠져나간다면 이것도 count 해줘야함
                    completion.add(pollCount);
                }
            }
            else{
						//다음 작업이 아직 완료되지 않았는데
                if(pollCount != 0){
								//이전 작업까지 한꺼번에 완료돼서 큐를 빠져나간 것을 계산 안 했다면
                    completion.add(pollCount);
										//모두 완성했음을 표현
                }
                pollCount = 0;
								//이제 다음 작업에 대한 연산을 진행해야하므로 다시 0으로 초기화한다
            }
        }
        
        answer = new int[completion.size()];
        for(int i = 0; i < completion.size(); i++){
            answer[i] = completion.get(i);
        }
        return answer;
    }
}

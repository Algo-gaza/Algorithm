import java.util.*;

class Car {
    int all_time;
    int in_time;
    boolean in_out;

    public Car(int i, boolean in) {
        in_time = i;
        in_out = in;
        all_time = 0;
    }
}

class Solution {
    public static int[] solution(int[] fees, String[] records) {

        Map<String, Car> map = new HashMap<>();
        for(int i=0; i<records.length; i++) {

            StringTokenizer st = new StringTokenizer(records[i], " :");

            String t = st.nextToken(); int time=0;

            if(t.charAt(0)=='0') t = t.replaceFirst("0", "");
            time += Integer.parseInt(t)*60;

            t = st.nextToken();
            if(t.charAt(0)=='0') t = t.replaceFirst("0", "");
            time += Integer.parseInt(t);

            String car_num = st.nextToken();

            if(map.containsKey(car_num)){
                Car now = map.get(car_num);

                if(now.in_out == true) {
                    now.all_time = now.all_time + (time - now.in_time);
                    now.in_out = false;
                }

                else if(now.in_out == false) {
                    now.in_out = true;
                    now.in_time = time;
                }
            }
            else map.put(car_num, new Car(time, true));
        }

        List<String> list = new ArrayList<>();

        for(String s : map.keySet()) {
            if(map.get(s).in_out == true )
                map.get(s).all_time += (1439 - map.get(s).in_time);
            list.add(s);
        }

        list.sort(null);

        int[] answer = new int[list.size()]; int i=0;

        for(String key : list) {
            int min = map.get(key).all_time;
            int price = 0;

            if(min-fees[0]<=0) price = fees[1];
            else {
                if((min-fees[0])%fees[2]==0) 
                    price += ((min-fees[0])/fees[2])*fees[3] + fees[1];
                else 
                    price += ((min-fees[0])/fees[2])*fees[3] + fees[3] + fees[1];
            }
            answer[i++] = price;
        }

        return answer;
    }
}

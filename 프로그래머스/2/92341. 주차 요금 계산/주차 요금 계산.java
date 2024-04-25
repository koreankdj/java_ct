import java.util.*;
import java.io.*;
/*
    1. 입차 & 출차 기록이 있을 때, 차량별로 주차 요금을 계산하기

*/

class Solution {
    
    static class Car{
        int intime, sumtime;
        public Car(int intime, int sumtime){
            this.intime = intime;
            this.sumtime = sumtime;
        }
    }
    
    static Map<String, Car> map = new HashMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;
        int k = records.length;
        
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String number = st.nextToken();
            String status = st.nextToken();
            
            //System.out.println("test : " + calminute(2359));
            
            int t = calminute(Integer.parseInt(time.substring(0, 2) + time.substring(3, 5)));
            if(status.equals("IN")){
                if(map.get(number) != null){
                    Car car = map.get(number);
                    map.put(number, new Car(t, car.sumtime));
                }else{
                    map.put(number, new Car(t, 0));
                }
            }else{
                Car car = map.get(number);
                int up_time = t - car.intime;
                //System.out.println(number + " : " + "outtime : " + t + " " + up_time);
                map.put(number, new Car(0, t-car.intime + car.sumtime));
            }
        }
        
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int[] answer = new int[keys.size()];
        for(int i = 0; i < keys.size(); i++){
            String car_num = keys.get(i);
            Car car = map.get(car_num);
            int endtime = car.sumtime;
            if(car.intime != 0 || car.sumtime == 0){
                endtime += calminute(2359)-car.intime;
            }
            answer[i] = calfee(fees, endtime);
            //System.out.println(car_num + " : " + endtime);
            //System.out.println(car_num + " : " + calfee(fees, endtime));
        }
        
        
        return answer;
    }
    
    static public int calminute(int time){
        int result = 0;
        int h = 0;
        if(time >= 100){
            h = time / 100;
            time -= h * 100;
        }
        result = h * 60 + time;
        return result;
    }
    
    static public int calfee(int[] fees, int time){
        
        int money = 0;
        
        // 기본 시간보다 작을 경우
        if(time <= fees[0]){
            return fees[1];
        }else{
            time -= fees[0];
            money += fees[1];
            money += (int) Math.ceil((double) time / (double) fees[2]) * fees[3];
        }
        return money;
    }
}
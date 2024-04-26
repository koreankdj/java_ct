import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int len = scoville.length;
        for(int i = 0; i < len; i++){
            pq.offer(scoville[i]);
        }
        
        int answer = 0;
        boolean flag = false;
        while(pq.size()>1){
            int ingre1 = pq.poll();
            if(ingre1 >= K){
                return answer;
            }
            int ingre2 = pq.poll();
            
            int mix = ingre1 + ingre2*2;
            answer++;
            pq.offer(mix);
        }
        if(pq.poll() >= K){
            return answer;
        }
        return -1;
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        
        int cnt = enemy.length;
        int life = n;
        int item = k;
        
        for(int i = 0; i < cnt; i++){
            life -= enemy[i];
            pq.offer(enemy[i]);
            
            if(life < 0){
                
                if(item == 0){
                    return i;
                }else{
                    item -= 1;
                    life += pq.poll();
                    //System.out.printf("(%d) [남은 item : %d]  남은 생명 : %d \n", i, item, life);
                }
            }
        }
        return cnt;
        
    }
}
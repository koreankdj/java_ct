import java.util.*;

class Solution {
    
    static int[] dc = {10, 20, 30, 40};     // 할인율 저장한 변수
    static int[] selected;                  // 선택된 이모티콘의 할인율
    
    static int people, e_num;
    static int cnt, ans;
    
    public int[] solution(int[][] users, int[] emoticons) {
  
        // 가입 할 회원 수를 저장할 변수
        int members = 0;
        
        // 최대 판매 금액을 저장할 변수
        int costs = 0;
        
        // 사용자의 수 & 이모티콘 수
        people = users.length;
        e_num = emoticons.length;
        
        selected = new int[e_num];
        
        perm(0, users, emoticons);
        
        
        int[] answer = {cnt, ans};
        
        return answer;
    }
    
    public void perm(int depth, int[][] users, int[] emoticons){
        
        // 다 뽑음(selected에는 할인율이 들어있음)
        if(depth == selected.length){
            int cnt_temp = 0;
            int sum = 0;    
            // 사람마다 돌면서 확인
            for(int i = 0; i < people; i++){
                int sum_temp = 0;
                for(int j = 0; j < e_num; j++){
                    // 만약 할인율이 더 클 경우, 이모티콘 구매
                    if(users[i][0] <= selected[j]){
                        sum_temp += emoticons[j] * (100 - selected[j])/100;
                    }
                }
                // 구매 금액보다 클 경우, 이모티콘 플러스 구매
                if(sum_temp >= users[i][1]){
                    sum_temp = 0;
                    cnt_temp++;
                }
                sum += sum_temp;
            }
            if(cnt_temp > cnt){
                cnt = cnt_temp;
                ans = sum;
            }else if(cnt_temp == cnt){
                ans = Math.max(ans, sum);
            }
            return;
        }
        for(int i = 0; i < 4; i++){
            selected[depth] = dc[i];
            perm(depth + 1, users, emoticons);
        }
    }
    
}
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        // 초기 세팅 (체육복 입을 수 있는 학생 수)
        answer = n - lost.length;
        
        // 1. 여벌 옷이 있는데, 도난 당했을 경우.
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i]==reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        // 2. 여벌 옷이 있어서, 옷을 빌릴 수 있는 경우
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(reserve[j] == -1) continue;
                
                // 빌릴 수 있는 경우
                if(Math.abs(lost[i] - reserve[j])==1){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
        
        
    }
}
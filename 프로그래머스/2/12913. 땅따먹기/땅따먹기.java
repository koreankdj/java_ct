import java.util.*;

class Solution {
    
    int solution(int[][] land) {

        int h = land.length;
        int w = land[0].length;
        
        int[][] dp = new int[h][w];
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(i == 0) dp[i][j] = land[i][j];   // 1행은 land 그대로 입력
                else{
                    int temp = 0;
                    for(int k = 0; k < w; k++){ // 이전 행을 위한 반복문
                        if(k == j) continue;
                        else{
                            temp = Math.max(temp, dp[i-1][k]);
                        }
                    }    
                    dp[i][j] = land[i][j] + temp;
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < w; i++){
            answer = Math.max(answer, dp[h-1][i]);
        }
        
        return answer;
    }
}
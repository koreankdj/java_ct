import java.util.*;
import java.io.*;

class Solution {
    static int answer;
    static int[] sum;
    static boolean[][] visited;
    
    static int N, M;
    
    static int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    
    public int solution(int[][] land) {
        
        N = land.length;
        M = land[0].length;
        sum = new int[M];
        visited = new boolean[N][M];
        
        for(int j = 0; j < M; j++){
            search(land, j);
        }
        //System.out.println(Arrays.toString(sum));
        
        return answer;
    }
    
    // 열로 돌면서 석유 시추하는 함수
    public static void search(int[][] land, int j){
        
        for(int i = 0; i < N; i++){
            if(land[i][j] == 1 && !visited[i][j]) bfs(land, i, j);
        }
        
        answer = Math.max(answer, sum[j]);
    }
    
    // 석유 시추 함수
    public static void bfs(int[][] land, int h, int w){
        Queue<int[]> q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        q.offer(new int[]{h, w});
        visited[h][w] = true;
        int cnt = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ch = cur[0];
            int cw = cur[1];
            
            set.add(cw);
            
            for(int i = 0; i < 4; i++){
                int nh = ch + dir[i][0];
                int nw = cw + dir[i][1];
                
                if(!inMap(nh, nw) || land[nh][nw] == 0 || visited[nh][nw]) continue;
                q.offer(new int[]{nh, nw});
                visited[nh][nw] = true;
                cnt++;
            }
        }
        //System.out.printf("[%d, %d] : %d\n", h, w, cnt);
        for(int now : set){
            sum[now] += cnt;
        }
    }
    
    public static boolean inMap(int h, int w){
        return 0 <= h && h < N && 0 <= w && w < M;
    }

    
}
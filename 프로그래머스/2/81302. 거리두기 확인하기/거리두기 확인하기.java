import java.util.*;


/*
    1. 응시자를 기준으로 거리가 2이내, 거리유지 여부를를 확인할 수 있도록.
    2. bfs

*/

class Solution {
    
    static int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    
    static boolean flag;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int k = 0; k < 5; k++){
            char[][] map = new char[5][5];
            for(int i = 0; i < 5; i++){
                map[i] = places[k][i].toCharArray();
            }

            flag = true;
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(map[i][j]=='P' && flag){
                        bfs(new int[] {i, j}, map);
                    }
                }
            }
            if(flag) {
                answer[k] = 1;
            }else{
                answer[k] = 0;
            }
        }
        
        
        
        return answer;
    }
    
    public static void bfs(int[] start, char[][] map){
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nh = cur[0] + dir[i][0];
                int nw = cur[1] + dir[i][1];
                
                int ndepth = cur[2] + 1;
                
                if(!inMap(nh, nw) || visited[nh][nw] || map[nh][nw] == 'X') continue;
                
                if(ndepth <= 2 && map[nh][nw] == 'P'){
                    flag = false;
                    return;
                }
                
                q.offer(new int[]{nh, nw, ndepth});
                visited[nh][nw] = true;
            }
        }
        
    }
    
    public static boolean inMap(int h, int w){
        return (0 <= h && h < 5 && 0 <= w && w < 5);
    }
}
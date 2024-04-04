import java.util.*;

class Solution {
    
    static int N, M, result1, result2;
    static int[] start, lab, exit;
    static boolean flag1 = false, flag2 = false;
    static char[][] map;
    
    static int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    
    public int solution(String[] maps) {
        
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i] = maps[i].toCharArray();
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 'S'){
                    start = new int[] {i, j};
                }else if(map[i][j] == 'L'){
                    lab = new int[] {i, j};
                }else if(map[i][j] == 'E'){
                    exit = new int[] {i, j};
                }
            }
        }
        
        
        
        bfs1(start, 0, map);
        if(flag1){
            bfs2(lab, 0, map);             
        }


        if(!flag2) return -1;
        
        return result1 + result2;
    }
    
    
    
    // 레버를 찾는 bfs
    public static void bfs1(int[] start, int depth, char[][] map){
    
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[] {start[0], start[1], depth});
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nh = cur[0] + dir[i][0];
                int nw = cur[1] + dir[i][1];
                
                int ndepth = cur[2] + 1;
                
                if(!inMap(nh, nw) || visited[nh][nw] || map[nh][nw] == 'X') continue;
                
                if(map[nh][nw] == 'L'){
                    result1 = ndepth;
                    flag1 = true;
                    return;
                }
                q.offer(new int[]{nh, nw, ndepth});
                visited[nh][nw] = true;
            }
        }
        
    }
    
    // 출구를 찾는 bfs
    public static void bfs2(int[] start, int depth, char[][] map){
    
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[] {start[0], start[1], depth});
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nh = cur[0] + dir[i][0];
                int nw = cur[1] + dir[i][1];
                
                int ndepth = cur[2] + 1;
                
                if(!inMap(nh, nw) || visited[nh][nw] || map[nh][nw] == 'X') continue;
                
                if(map[nh][nw] == 'E'){
                    result2 = ndepth;
                    flag2 = true;
                    return;
                }
                q.offer(new int[]{nh, nw, ndepth});
                visited[nh][nw] = true;
            }
        }
        
    }  
    
    public static boolean inMap(int h, int w){
        return 0 <= h && h < N && 0 <= w && w < M;
    }
    
}
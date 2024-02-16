import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, M, D, cnt;
    static int[] archers;
    static int[] s_archers;
    static int[][] map;
    
    static class enemy implements Comparable<enemy>{
        int y;
        int x;
        boolean isdead = false;
        enemy(int y, int x){
            this.y = y;
            this.x = x;
        }
        @Override
        public int compareTo(enemy o) {
            return this.x != o.x ? this.x - o.x : o.y - this.y;
        }
        @Override
        public String toString() {
            return "enemy [y=" + y + ", x=" + x + "]";
        }
        
        
    }
    
    static ArrayList<enemy> enemys = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        archers = new int[M];
        s_archers = new int[3];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    enemys.add(new enemy(i, j));
                }
            }
        }
        Collections.sort(enemys);
        
        for(int i = 0; i < M; i++) {
            archers[i] = i;
        }
        
//        for(int i = 0; i < enemys.size(); i++) {
//            System.out.println(enemys.get(i));
//        }
        
        
        
        cnt = 0;
        pick_archer(0, 0);
        System.out.println(cnt);
    }
    
    public static void pick_archer(int cnt, int start) {
        if(cnt == 3) {
            ArrayList<enemy> c_enemys = new ArrayList<>();
            
            for(int i = 0; i < enemys.size(); i++) {
                int c_x = enemys.get(i).x;
                int c_y = enemys.get(i).y;
                enemy c_e = new enemy(c_y, c_x);
                c_enemys.add(c_e);
            }
            
            kill(s_archers, c_enemys);
            return;
        }
        
        for(int i = start; i < M; i++) {
            s_archers[cnt] = archers[i];
            pick_archer(cnt + 1, i + 1);
        }
    }
    
    
    public static void kill(int[] arc, ArrayList<enemy> c_enemys) {
        int kills = 0;
        
        while(c_enemys.size() > 0) {
            for(int i = 0; i < 3; i++) {
                int e_size = c_enemys.size();
                
                int dist = 30;
                int tempidx = 0;
                
                for(int j = 0; j < e_size; j++) {
                    
                    int tempdist = 0;
                    if(c_enemys.size() == 0) break;
                    
                    int[] cur_a = new int[] {N, arc[i]};
                    int[] cur_e = new int[] {c_enemys.get(j).y, c_enemys.get(j).x};
                    
                    tempdist = dist(cur_a, cur_e);
                    if(dist > tempdist) {
                        dist = tempdist;
                        tempidx = j;
                    }
                }
                
                if(dist <= D) {
                    //System.out.printf("[%d 궁수] -> [%d, %d 적] kill\n", i, c_enemys.get(tempidx).y, c_enemys.get(tempidx).x);
                    
                    c_enemys.get(tempidx).isdead = true;
                }
            }
            
            
            for(int i = 0; i < c_enemys.size(); i++) {
            
                if(c_enemys.get(i).isdead) {
                    //System.out.println(i + " dead");
                    c_enemys.remove(i--);
                    kills++;
                    continue;
                }else {
                    if(c_enemys.get(i).y == N-1) {
                        //System.out.println(i + " out");
                        c_enemys.remove(i--);
                    }
                    else {
                        //System.out.println(i + " 이동");
                        c_enemys.get(i).y += 1;
                    }
                }
                
            }
            //System.out.println("현재 kill 한 적" + kills);
        }
        cnt = Math.max(cnt, kills);
    }
    
    public static void print() {
        System.out.println("===== 중간 점검 =====");
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    public static int dist(int[] p1, int[] p2) {
        return(Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]));
    }

}
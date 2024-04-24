import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, cond;				// st는 0이면 가로 상태, 1이면 세로 상태
	static boolean flag = false;
	static char[][] map;
	static boolean[][][] visited;
	
	static int[] s_idx, e_idx;
	
	static int[][] dir = {
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[2][N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		find();
		bfs();
		if(!flag) System.out.println(0);
	}
	
	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {s_idx[0], s_idx[1], 0, cond});
		
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int ch = cur[0];
			int cw = cur[1];
			int cdepth = cur[2];
			int ccond = cur[3];
			if(visited[ccond][ch][cw]) continue;
			
			//System.out.printf("[%d] h : %d   w : %d   방향 : %d \n", cdepth, ch, cw, ccond);
			
			if(checkans(ch, cw, ccond)) {
				System.out.println(cdepth);
				flag = true;
				return;
			}
			
			visited[ccond][ch][cw] = true;
			for(int i = 0; i < 4; i++) {
				int nh = ch + dir[i][0];
				int nw = cw + dir[i][1];
				
				if(!inMap(nh, nw) || visited[ccond][nh][nw] || !canGo(nh, nw, ccond)) continue;
				q.offer(new int[] {nh, nw, cdepth+1, ccond});
			}
			
			if(canRotate(ch, cw, ccond)) {
				if(ccond == 0) {
					if(!visited[1][ch][cw]) {
						q.offer(new int[] {ch, cw, cdepth+1, 1});
					}
				}else {
					if(!visited[0][ch][cw]) {
						q.offer(new int[] {ch, cw, cdepth+1, 0});
					}
				}
			}
			
		}
	}
	
	public static boolean canGo(int h, int w, int cd) {
		
		if(map[h][w] == '1') return false;
		
		if(cd == 0) {	// 세로일 때 다음 갈 수 있는지 여부
			if(inMap(h, w-1) && map[h][w-1] != '1' && inMap(h, w+1) && map[h][w+1] != '1') return true;
		}else {			// 가로일 때 다음 갈 수 있는지 여부
			if(inMap(h-1, w) && map[h-1][w] != '1' && inMap(h+1, w) && map[h+1][w] != '1') return true;
		}
		
		return false;
	}
	
	public static boolean checkans(int h, int w, int cd) {
		
		if(h != e_idx[0] || w != e_idx[1]) return false;
		
		if(cd == 0) {
			if(inMap(h, w-1) && map[h][w-1] == 'E' && inMap(h, w+1) && map[h][w+1] == 'E') return true;
		}else {
			if(inMap(h-1, w) && map[h-1][w] == 'E' && inMap(h+1, w) && map[h+1][w] == 'E') return true;
		}
		return false;
	}
	
	// 회전할 수 있는지 확인하는 함수
	public static boolean canRotate(int h, int w, int cd) {
		
		for(int i = h-1; i <= h+1; i++) {
			for(int j = w-1; j <= w+1; j++) {
				if(!inMap(i, j) || map[i][j] == '1') return false;
			}
		}
		return true;
	}
	
	public static void find() {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'B') {				// 시작 지점
					if(inMap(i-1, j) && map[i-1][j] =='B' && inMap(i+1, j) && map[i+1][j] == 'B') {			// 세로 상태
						cond = 1;
						s_idx = new int[]{i, j};
					}else if(inMap(i, j-1) && map[i][j-1] =='B' && inMap(i, j+1) && map[i][j+1] == 'B') {
						cond = 0;
						s_idx = new int[]{i, j};
					}
				}else if(map[i][j] == 'E') {		// 종료 지점
					if(inMap(i-1, j) && map[i-1][j] =='E' && inMap(i+1, j) && map[i+1][j] == 'E') {			// 세로 상태
						e_idx = new int[]{i, j};
					}else if(inMap(i, j-1) && map[i][j-1] =='E' && inMap(i, j+1) && map[i][j+1] == 'E') {
						e_idx = new int[]{i, j};
					}
				}
			}
		}
	}
	
	public static boolean inMap(int h, int w) {
		
		return 0 <= h && h < N && 0 <= w && w < N;
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, cnt, flag;
	static char[][] map;
	static boolean[][] visited;
	
	static int[][] dir = {
			{-1, 1},	// 우상
			{0, 1},		// 우
			{1, 1},		// 우하
	};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		cnt = 0;
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			flag = 0;
			dfs(i, 0);
		}
		
		//System.out.println("== 결과 == ");
		//print();
		
		int ans = 0;
		for(int i = 0; i < R; i++) {
			if(visited[i][C-1]) ans++;
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int r, int c) {
		
		
		if(flag == 1) return;
		visited[r][c] = true;
		
		
		if(c == C - 1 && flag == 0) {
			//System.out.printf("[%d %d] - 도착 ! \n", r, c);
			//print();
			cnt++;
			flag = 1;
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(nr < 0 || nr >= R || visited[nr][nc] || map[nr][nc] == 'x') continue;
			
			dfs(nr, nc);
		}
	}
	
	public static void print() {
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(visited[i][j]) {
					System.out.print("O ");
				}else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
		
	}
	
	/*
	public static void bfs(int r, int c) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{r, c});
		visited[r][c] = true;
		
		loop:
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			if(cc == C-1) return;		// 최종에 도달했을 때
			
			for(int i = 0; i < 3; i++) {
				int nr = cr + dir[i][0];
				int nc = cc + dir[i][1];
				
				if(nr < 0 || nr >= R || visited[nr][nc] || map[nr][nc] == 'x') continue;
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				if(nc == C - 1) {
					continue loop;
				}
			}
			
			
		}
	}
	*/
	
}
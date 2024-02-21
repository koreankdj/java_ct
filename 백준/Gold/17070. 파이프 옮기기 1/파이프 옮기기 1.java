import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] dir = {
			{0, 1, 0},	// 가로
			{1, 1, 1},	// 대각선
			{1, 0, 2},	// 세로
	}; 
	
	static int N, ans;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		dfs(0, 1, 0);
		System.out.println(ans);
	}
	
	// status 는 가로, 세로, 대각선을 표현할 변수
	public static void dfs(int h, int w, int status) {
		
		if(h == N-1 && w == N-1) {
			ans++;
			return;
		}
		
		switch(status) {
		case 0:	// 가로 상황
			for(int i = 0; i < 2; i++) {
				int n_h = h + dir[i][0];
				int n_w = w + dir[i][1];
				
				if(!inMap(n_h, n_w) || !possible(n_h, n_w, dir[i][2])) continue;
				
				dfs(n_h, n_w, dir[i][2]);
			}
			break;
		case 1:	// 대각선 상황
			for(int i = 0; i < 3; i++) {
				int n_h = h + dir[i][0];
				int n_w = w + dir[i][1];
				
				if(!inMap(n_h, n_w) || !possible(n_h, n_w, dir[i][2])) continue;
				
				dfs(n_h, n_w, dir[i][2]);
			}
			break;
		case 2:	// 세로 상황
			for(int i = 1; i < 3; i++) {
				int n_h = h + dir[i][0];
				int n_w = w + dir[i][1];
				
				if(!inMap(n_h, n_w) || !possible(n_h, n_w, dir[i][2])) continue;
				
				dfs(n_h, n_w, dir[i][2]);
			}
			break;
		}
		
	}
	
	public static boolean possible(int h, int w, int k) {
		
		// 상태에 맞게 체크해야할 칸 확인
		switch(k) {
		case 0:
			return(map[h][w] == 0);
		case 1:
			return(map[h][w] == 0 && map[h-1][w] == 0 && map[h][w-1] == 0);
		case 2:
			return(map[h][w] == 0);
		}
		
		return false;
	}
	
	public static boolean inMap(int x, int y) {
		return (0<= x && x < N && 0 <= y && y < N);
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R, cnt;
	static int[][] map;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < Math.min(N, M) / 2; i++) {
			for(int j = 0; j < R; j++) {
				rotate(i);
			}
		}

		for(int i = 0; i < N; i++) {
			for(int k = 0; k < M; k++) {
				sb.append(map[i][k]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static void rotate(int x) {
		
		int temp = map[x][x];
		
		//윗면
		for(int i = x; i < M-x-1; i++) {
			map[x][i] = map[x][i + 1];
		}
		//우측면
		for(int i = x; i < N-x-1; i++) {
			map[i][M-x-1] = map[i+1][M-x-1];
		}
		
		//아랫면
		for(int i = M-x-1; i > x; i--) {
			map[N-x-1][i] = map[N-x-1][i-1];
		}
		
		//좌측면
		for(int i = N-x-1; i > x; i--) {
			map[i][x] = map[i-1][x];
		}
		
		map[x+1][x] = temp;
	}
	
	public static boolean inMap(int x, int y) {
		return (0 <= x && x < N && 0 <= y && y < M);
	}

}
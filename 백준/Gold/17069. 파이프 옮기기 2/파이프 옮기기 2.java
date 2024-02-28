import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static long[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		dp = new long[N + 1][N + 1][3];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][2][0] = 1;
		search();
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}
	
	public static void search() {
		
		for(int i = 1; i <= N; i++) {
			
			for(int j = 3; j <= N; j++) {
				
				if(map[i][j] == 1) continue;
				
				// 가로로 도착하는 경우? 이전 가로 도착 + 이전 대각선 도착
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
				if(i == 1) continue;	// 맨 윗줄인 경우
				
				// 세로로 도착하는 경우? 이전 세로 도착 + 이전 대각선 도착
				dp[i][j][2] = dp[i-1][j][2] + dp[i-1][j][1];
				
				if(map[i-1][j] == 1 || map[i][j-1] == 1) continue;
				
				// 대각선으로 도착하는 경우? 이전 가로, 세로, 대각선 도착
				dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][2] + dp[i-1][j-1][1];
			}
		}
	}
	
	
}
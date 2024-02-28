import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map, dp;
	
	static int[][] dir = {
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], -1);
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		System.out.println(solve(0, 0));
		/*
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}*/
		
	}
	
	public static int solve(int h, int w) {
		
		if(h == N-1 && w == M-1) return 1;
		
		if(dp[h][w] != -1) return dp[h][w];
		
		dp[h][w] = 0;
		
		for(int i = 0; i < 4; i++) {
			int nh = h + dir[i][0];
			int nw = w + dir[i][1];
			
			if(nh < 0 || nh >= N || nw < 0 || nw >= M) continue;
			dp[h][w] += map[h][w] > map[nh][nw] ? solve(nh, nw) : 0; 
		}
		
		return dp[h][w];
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, W;
	
	static int[][] item; 
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		item = new int[N + 1][2];
		dp = new int[W + 1];
		
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());	// 무게
			item[i][1] = Integer.parseInt(st.nextToken());	// 가치
			
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = W; j >= 0; j--) {
				if(dp[j] != -1 && j + item[i][0] <= W) {
					dp[j + item[i][0]] = Math.max(dp[j + item[i][0]], dp[j] + item[i][1]);
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i <= W; i++) {
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}

}
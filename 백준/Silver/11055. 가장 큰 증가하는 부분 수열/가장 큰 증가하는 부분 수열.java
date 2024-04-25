import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] dp, num;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			dp[i] = num[i];
		}
		
		dp[0] = num[0];
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < i; j++) {
				if(num[i] > num[j]) {
					dp[i] = Math.max(dp[i], num[i]+dp[j]);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}

}
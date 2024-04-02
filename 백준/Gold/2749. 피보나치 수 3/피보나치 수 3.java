import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		
		int pisano = 1500000;
		long[] dp = new long[pisano];
		dp[0] = 0;
		dp[1] = 1;

		
		for(int i = 2; i < pisano && i <=n ; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1000000;
		}
		
		if(n >= pisano) {
			n %= pisano;
		}
		
		System.out.println(dp[(int)n]);
		
	}
}
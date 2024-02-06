import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, M, ans;
	static int[] snacks, selected;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snacks = new int[N];
			selected = new int[2];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			Combi(0, 0);
			if(ans == 0) {
				System.out.printf("#%d -1\n", tc);
			}else {
				System.out.printf("#%d %d\n", tc, ans);
			}
		}
	}
	
	private static void Combi(int cnt, int start) {
		if(cnt==2){
			int sum = 0;
			for(int i = 0; i < 2; i++) {
				sum += selected[i];
			}
			if(sum <= M) ans = Math.max(ans, sum);
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[cnt] = snacks[i];
			Combi(cnt + 1, i + 1);
		}
	}
	
	

}
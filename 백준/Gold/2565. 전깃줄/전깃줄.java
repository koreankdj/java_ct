import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static ArrayList<int[]> lines;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		// N 개의 전깃줄
		N = Integer.parseInt(br.readLine());
		lines = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			lines.add(new int[] {from, to});
		}
		//lines.sort((s1, s2) -> Integer.compare(s1[0], s2[0]));
		//lines.sort(Comparator.comparingInt(s -> s[0]));
		lines.sort((s1, s2) -> s1[0] - s2[0]);
		
		// LIS를 dp 배열에 저장
		int[] dp = new int[N];
		for(int i = 0; i < lines.size(); i++) {
			int max_n = 0;
			for(int j = i; j >= 0; j--) {
				if(lines.get(i)[1] >= lines.get(j)[1]) max_n = Math.max(max_n, dp[j]);
			}
			dp[i] = max_n + 1;
		}
		
		
		int answer = 0;
		for(int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		answer = N - answer;
		
		System.out.println(answer);
	}
}
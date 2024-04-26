import java.util.Scanner;

public class Solution {

	static int T;
	static int N, L;
	static int[][] ingre;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			N = sc.nextInt();
			L = sc.nextInt();
			ingre = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				ingre[i][0] = sc.nextInt();		// 맛 점수
				ingre[i][1] = sc.nextInt();		// 칼로리 수치
			}
			
			ans = 0;
			dfs(0, 0, 0);
			
			System.out.printf("#%d %d\n", t, ans);
		}
		
	}
	
	public static void dfs(int idx, int c_sum, int l_sum) {
		
		if(c_sum > L) return;
		
		if(idx == N) {
			ans = Math.max(ans, l_sum);
			return;
		}
		
		// 해당 재료를 선택한 경우
		dfs(idx+1, c_sum + ingre[idx][1], l_sum + ingre[idx][0]);
		
		// 해당 재료를 선택하지 않은 경우
		dfs(idx+1, c_sum, l_sum);
	}

}
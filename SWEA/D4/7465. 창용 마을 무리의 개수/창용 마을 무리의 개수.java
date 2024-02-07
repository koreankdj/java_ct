import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, M, ans;
	static boolean[] visited;
	static ArrayList<Integer>[] edge;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			edge = new ArrayList[N + 1];
			visited = new boolean[N + 1];
			for(int i = 1; i <=N ; i++) {
				edge[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				edge[from].add(to);
				edge[to].add(from);	
			}
			
			ans = 0;
			for(int i = 1; i <= N; i++) {
				if(!visited[i]) {
					dfs(i);
					ans++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, ans);
			
			
		}
	}
	
	public static void dfs(int cur) {
		visited[cur] = true;
		
		for(int next : edge[cur]) {
			if(visited[next]) continue;
			dfs(next);
		}
	}

}
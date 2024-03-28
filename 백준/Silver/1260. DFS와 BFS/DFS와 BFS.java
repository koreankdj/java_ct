import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		
		// 입력 받기 
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[from][to] = 1;
			map[to][from] = 1;
		}
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
	}
	
	public static void dfs(int k) {
		visited[k] = true;
		System.out.print(k + " ");
		
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			
			if(map[k][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for(int i = 1; i <= N; i++) {
				if(visited[i]) continue;
				
				if(map[cur][i] == 1) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}

}
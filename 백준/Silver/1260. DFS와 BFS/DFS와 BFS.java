import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	static int N, M, V;
	
	static int[][] adjMatrix;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();
		bfs();
		
	}
	
	public static void dfs(int cur) {

		visited[cur] = true;
		System.out.print(cur + " ");
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && adjMatrix[cur][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N+1];
		
		q.offer(V);
		visited[V] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && adjMatrix[cur][i] == 1) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}

}
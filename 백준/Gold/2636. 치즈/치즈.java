import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans, last, sum;
	static int[][] map;
	static boolean[][] visited;
	
	static int[][] dir = {
			{-1, 0},
			{1, 0},
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
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) sum++;
			}
		}
		
		// sum 에는 1의 개수가 저장됨
		
		ans = 0;
		while(sum > 0) {
			last = sum;
			visited = new boolean[N][M];
			

			bfs(0, 0);
			ans++;
		}
		
		System.out.println(ans);
		System.out.println(last);
		
	}
	
	public static void bfs(int h, int w) {
		
		Queue<int[]> q = new LinkedList<>();
		visited[h][w] = true;
		q.offer(new int[] {h, w});
		
		while(!q.isEmpty()) {
			int c_h = q.peek()[0];
			int c_w = q.peek()[1];
			q.poll();
			
			for(int i = 0; i < 4; i++) {
				int n_h = c_h + dir[i][0];
				int n_w = c_w + dir[i][1];
				
				if(!inMap(n_h, n_w) || visited[n_h][n_w]) continue;
				
				if(map[n_h][n_w] == 0) {
					q.offer(new int[] {n_h, n_w});
					visited[n_h][n_w] = true;
				}else {
					map[n_h][n_w] = 0;
					sum--;
					visited[n_h][n_w] = true;
				}
				
			}
		}
	}
	
	public static boolean inMap(int h, int w) {
		return (0 <= h && h < N && 0 <= w && w < M);
	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
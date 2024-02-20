import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	
	static int[][] dir = {
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};
	
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i < K; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			fillMap(x1, y1, x2, y2);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					pq.add(bfs(i, j));
				}
			}
		}
		
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
		
		
	}
	
	public static void fillMap(int w1, int h1, int w2, int h2) {
		for(int i = h1; i < h2; i++) {
			for(int j = w1; j < w2; j++) {
				map[i][j] = 1;
			}
		}
	}
	
	public static int bfs(int h, int w) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{h, w});
		
		int total = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int ch = now[0];
			int cw = now[1];
			
			if(visited[ch][cw]) continue;		// 이미 방문한 좌표인 경우 스킵 
			total++;
			
			
			visited[ch][cw] = true;
			//System.out.printf("[%d %d] 탐색중 \n", ch, cw);
			
			for(int i = 0; i < 4; i++) {
				int nh = ch + dir[i][0];
				int nw = cw + dir[i][1];
				
				if(0 <= nh && nh < M && 0 <= nw && nw < N && map[nh][nw] == 0 && !visited[nh][nw]) {
					q.offer(new int[] {nh, nw});
				}
			}
		}
		
		return total;
	}


}
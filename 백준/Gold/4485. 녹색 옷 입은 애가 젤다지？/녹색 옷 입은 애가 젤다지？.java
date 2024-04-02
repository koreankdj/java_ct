import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = Integer.MAX_VALUE >> 2;
	static int N;
	static int[][] map, cost_map;
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int[][] dir = {
		{1, 0},
		{-1, 0},
		{0, 1},
		{0, -1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N > 0) {
				map = new int[N][N];
				cost_map = new int[N][N];
				
				for(int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j = 0; j < N; j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
						cost_map[i][j] = INF;
					}
				}
				
				dijkstra();
				//print();
				
				System.out.printf("Problem %d: %d\n", t++, cost_map[N-1][N-1]);
			}else {
				break;
			}
		}
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		cost_map[0][0] = map[0][0];
		pq.add(new Node(0, 0, map[0][0]));
		
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();

			for(int i = 0; i < 4; i++) {
				int nh = cur.x + dir[i][0];
				int nw = cur.y + dir[i][1];
				
				if(!inMap(nh, nw)) continue;
				
				if(cost_map[nh][nw] > cost_map[cur.x][cur.y] + map[nh][nw]) {
					cost_map[nh][nw] = cost_map[cur.x][cur.y] + map[nh][nw];
					pq.add(new Node(nh, nw, cost_map[nh][nw]));
					
				}
			}
		}
	}
	
	public static boolean inMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(cost_map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
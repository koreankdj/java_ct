import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int T, N;
	static int d_x, d_y;		// 목적지 위치
	static ArrayList<int[]> areas;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++)
		{
			N = Integer.parseInt(br.readLine());
			areas = new ArrayList<>();
			
			for(int i = 0; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int[] area = {x, y};
				areas.add(area);
			}
			
			st = new StringTokenizer(br.readLine());
			d_x = Integer.parseInt(st.nextToken());
			d_y = Integer.parseInt(st.nextToken());
			
			
			if(bfs()) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}
		
		
		
		
	}
	
	public static boolean bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.offer(areas.get(0));
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nx = now[0];
			int ny = now[1];
			
			if(dist(nx, ny, d_x, d_y) <= 1000) return true;
			
			for(int i = 0, size = areas.size(); i < size; i++) {
				if(visited[i]) continue;
				if(dist(nx, ny, areas.get(i)[0], areas.get(i)[1]) <= 1000) {
					visited[i] = true;
					q.offer(areas.get(i));
				}
			}
		}
		return false;
	}
	
	
	public static int dist(int x1, int y1, int x2, int y2) {
		
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
}
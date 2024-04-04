import java.util.*;
import java.io.*;

public class Solution {
	
	static int n, min;
	
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			
			map = new int[n][n];
			visited = new boolean[n][n];
			
			for(int i = 0; i < n; i++) {
				String s = br.readLine();
				for(int j = 0; j < n; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			bfs(0, 0);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	
	static void bfs(int x, int y) {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		
		pq.add(new Pos(x, y, 0)); // 초기 값은 0
		visited[x][y] = true;
		
		while(!pq.isEmpty()) {
			Pos p = pq.poll();
			
			int curX = p.x;
			int curY = p.y;
			int curT = p.time;
			
			if(curX == n-1 && curY == n-1) {
				min = min > curT ? curT : min;
			}
			
			for(int k = 0; k < 4; k++) {
				int nx = curX + dx[k];
				int ny = curY + dy[k];
				
				if(nx < 0 || ny < 0 || ny >= n || nx >= n) continue;
				if(!visited[nx][ny]) {
					int totalTime = curT + map[nx][ny];
					pq.add(new Pos(nx, ny, totalTime));
					visited[nx][ny] = true;
				}
				
			}
			
		}
	}
	
	static class Pos implements Comparable<Pos>{
		int x, y;
		int time;
		
		Pos(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Pos o) {
			if(this.time < o.time) {
				return -1;
			} else if(this.time > o.time) {
				return 1;
			}
			return 0;
		}

	}
	
}
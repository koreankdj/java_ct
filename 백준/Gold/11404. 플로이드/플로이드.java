import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static final int INF = Integer.MAX_VALUE>>2;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i==j) map[i][j] = 0;
				else {
					map[i][j] = INF;
				}
			}
		}
		
		for(int v = 0; v < m; v++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			map[from][to] = Math.min(map[from][to], cost);
		}

		
		// 프로이드 + 워셜 (O(n^2))
		for(int k = 1; k <= n; k++) { 				// 경유지
			for(int i = 1; i <= n; i++) { 			// 출발지
				for(int j = 1; j <= n; j++) {		// 도착지
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		print();
		
		
	}
	
	public static void print() {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == INF) System.out.print("0 ");
				else {
					System.out.print(map[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

}
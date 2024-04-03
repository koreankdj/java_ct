import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int small = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());
			
			// 1. 키가 더 크다는 것(1)
			map[tall][small] = 1;
			map[small][tall] = -1;
		}
		
		//System.out.println("=== 플로이드 전 ===");
		//print();
		
		// 플로이드 워셜
		for(int k = 1; k <= N; k++) {					// 경	
			for(int i = 1; i <= N; i++) {				// 출
				
				// i 가 k 보다 크다면, k 가 큰 사람들은 모두 1에 표시
				if(map[i][k] == 1) {
					for(int j = 1; j <= N; j++) {			
						if(map[k][j] == 1) map[i][j] = 1;
					}
				}else if(map[i][k] == -1) {
					for(int j = 1; j <= N; j++) {			
						if(map[k][j] == -1) map[i][j] = -1;
					}
				}
			}
		}
		
		//System.out.println("=== 플로이드 후 ===");
		//print();
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			int temp = 0;
			for(int j = 1; j <= N; j++) {
				if(map[i][j] != 0) temp++;
			}
			
			if(temp == N-1) ans++;
		}
		System.out.println(ans);

	}
	public static void print() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
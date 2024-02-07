import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean[][] map = new boolean[100][100];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			paint(x, y);
		}
		
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j]) cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void solve() {
		
	}
	
	public static void paint(int x, int y) {
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(inMap(x+i, y+j)) {
					map[x+i][y+j] = true;
				}
			}
		}
		
	}
	
	
	public static boolean inMap(int x, int y) {
		
		return (0 <= x && x < 100 && 0 <= y && y < 100);
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] parents;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		make();
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int conn = Integer.parseInt(st.nextToken());
				if(conn == 1) {
					union(i, j);
				}
			}
		}
		
		int r = -1;
		boolean flag = true;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int next = Integer.parseInt(st.nextToken());
			
			if(r == -1 && flag) {
				r = find(next);
			}else if(flag){
				if(r != find(next)) flag = false;
			}
		}
		
		String msg = flag ? "YES" : "NO";
		System.out.println(msg);
	}
	
	public static void make() {
		map = new int[N+1][N+1];
		parents = new int[N+1];
		for(int i = 1; i < N; i++) {
			parents[i] = i;
		}
	}
	public static int find(int v) {
		if(parents[v] == v) return v;
		
		return parents[v] = find(parents[v]);
	}
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		if(aRoot<bRoot) {
			parents[bRoot] = aRoot;
		}else {
			parents[aRoot] = bRoot;
		}
		
		return true;
	}

}
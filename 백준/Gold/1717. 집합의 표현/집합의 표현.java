import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] parents;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		make();
		
		// 합집합 0, 확인 1
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			if(op == 0) {
				union(f, t);
			}else {
				if(find(f) == find(t)) {
					sb.append("YES").append("\n");
				}else {
					sb.append("NO").append("\n");
				}
			}
		}
		
		System.out.println(sb);
		
	}
	
	public static void make() {
		parents = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot < bRoot) {
			parents[bRoot] = aRoot;
		}else {
			parents[aRoot] = bRoot;
		}
	}

}
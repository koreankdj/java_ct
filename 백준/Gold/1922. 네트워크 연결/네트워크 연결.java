import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] parents;
	
	static class Edge implements Comparable<Edge>{
		int from, to, value;
		public Edge(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}
		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
	}
	
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		
		edges = new Edge[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(f, t, v);
		}
		
		kruscal();
		
		
	}
	
	public static void kruscal() {
		make();
		Arrays.sort(edges);
		int weight = 0;
		int cnt = 0;
		
		for(Edge edge : edges) {
			int f = edge.from;
			int t = edge.to;
			int w = edge.value;
			
			if(!union(f, t)) continue;
			weight += w;
			if(++cnt == N-1) break;
		}
		System.out.println(weight);
		
	}
	
	public static void make() {
		parents = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		if(aRoot < bRoot) {
			parents[bRoot] = aRoot;
		}else {
			parents[aRoot] = bRoot;
		}
		return true;
	}

}
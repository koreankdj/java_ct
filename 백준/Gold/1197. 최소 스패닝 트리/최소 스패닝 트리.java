import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int V, E;
	
	static class Edge implements Comparable<Edge>{
		int from, to, value;
		Edge(int from, int to, int value){
			this.from = from;
			this.to = to;
			this.value = value;
		}
		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
	}
	
	static int[] parents;
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edges = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(f, t, v);
		}
		
		kruscal();
		
	}
	
	public static void kruscal() {
		
		Arrays.sort(edges);
		make();
		
		int weight = 0;
		int c = 0;
		for(Edge edge : edges) {
			int f = edge.from;
			int t = edge.to;
			
			if(!union(f, t)) continue;
			weight += edge.value;
			if(++c == V - 1) break;
		}
		System.out.println(weight);
		
		
	}

	
	public static void make() {
		parents = new int[V + 1];
		for(int i = 1; i <= V; i++) {
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
		parents[bRoot] = aRoot;
		
		return true;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] parents;
	
	
	static class Line implements Comparable<Line>{
		int from, to, value;
		Line(int from, int to, int value){
			this.from = from;
			this.to = to;
			this.value = value;
		}
		
		@Override
		public int compareTo(Line o) {
			return this.value - o.value;
		}
	}
	
	static Line[] lines;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		lines = new Line[M];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			lines[i] = new Line(f, t, v);
		}
		
		kruscal();
	}
	
	public static void kruscal() {
		Arrays.sort(lines);
		make();
		
		int weight = 0;
		int cnt = 0;
		
		for(Line line : lines) {
			int f = line.from;
			int t = line.to;
			int v = line.value;
			
			if(!union(f, t)) continue;
			weight += v;
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
		
		if(aRoot == bRoot) return false;		// a 와 b 가 같은 트리에 속해있다. 
		
		parents[bRoot] = aRoot;
		return true;
	}

}
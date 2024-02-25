import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static long total;
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
	static StringBuilder sb;
	static Line[] lines;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) break;
			
			lines = new Line[M];
			
			total = 0;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int f = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				lines[i] = new Line(f, t, v);
				total += v;
			}
			
			kruscal();
		}
		
		System.out.println(sb);
		
	}
	
	public static void kruscal() {
		Arrays.sort(lines);
		
		make();
		long weight = 0;
		int cnt = 0;
		
		for(Line line : lines) {
			int f = line.from;
			int t = line.to;
			int v = line.value;
			
			if(!union(f, t)) continue;
			weight += v;
			if(++cnt == N - 1) break;
		}
		sb.append(total - weight).append('\n');
		
	}
	
	public static void make() {
		parents = new int[N];
		for(int i = 0; i < N; i++) {
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
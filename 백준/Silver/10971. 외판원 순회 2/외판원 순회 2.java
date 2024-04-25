import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, min_n;
	static int[] arr;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = i;
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min_n = Integer.MAX_VALUE;
		perm(0);
		System.out.println(min_n);
		
	}
	
	private static void perm(int depth) {
		
		// 순열 생성 완료 
		if(depth == N) {
			int sum = 0;
			int rtn = map[arr[N-1]][arr[0]];
			if(rtn == 0) return;
			
			for(int i = 0; i < N - 1; i++) {
				
				int from = arr[i];
				int to = arr[i+1];
				int cost = map[from][to];
				if(cost == 0) return;
				//System.out.printf("[%d -> %d]\n", from, to);
				
				sum += cost;
			}
			
			sum += rtn;
			min_n = Math.min(min_n, sum);
			
			return;
		}
		
		for(int i = depth; i < N; i++) {
			swap(i, depth);
			perm(depth + 1);
			swap(depth, i);
		}
	}
	
	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int T, N, X, K;
	static int[] cups;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		
			cups = new int[N + 1];
			cups[X] = 1;
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				swap(a, b);
			}
			
			int i;
			for(i = 1; i <= N; i++) {
				if(cups[i] == 1) {
					break;
				}
			}
			System.out.printf("%d\n", i);
		
		
	}
	public static void swap(int i, int j) {
		int temp = cups[i];
		cups[i] = cups[j];
		cups[j] = temp;
	}

}
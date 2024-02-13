import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] h;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		h = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(h);
		
		int idx = 0;
		while(true) {
			if(idx < N && K >= h[idx]) {
				idx++;
				K++;
			}else {
				System.out.println(K);
				break;
			}
		}
		
	}

}
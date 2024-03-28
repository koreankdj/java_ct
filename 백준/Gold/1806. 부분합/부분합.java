import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0, right =0;
		int sum = arr[0], ans = Integer.MAX_VALUE;
		
		while(left <= right) {

			if(sum < S) {
				right++;
				if(right == N) break;
				sum += arr[right];
			}else if(sum >= S) {
				int len = right - left + 1;
				ans = Math.min(ans, len);
				
				sum -= arr[left];
				left++;
			}
		}
		
		if(ans == Integer.MAX_VALUE) ans = 0;
		System.out.println(ans);
	}

}
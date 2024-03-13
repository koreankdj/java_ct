import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static long ans;
	static long[] times;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 심사관 수
		M = Integer.parseInt(st.nextToken());	// 친구들 수
		times = new long[N];

		
		for(int i = 0; i < N; i++) {
			times[i] = Long.parseLong(br.readLine());
		}
		
		// 배열 정렬
		Arrays.sort(times);
		
		long left = times[0];
		long right = (long) M * (times[N - 1]);	// 최댓값으로 세팅
		
		ans = Long.MAX_VALUE;
		while(left <= right) {
			
			long mid = (left + right) / 2;
			long sum = 0;
			
			for(long time : times) {
				long cntPerson = (mid/time);
				
				if(sum >= M || time > mid) break;
				
				sum += cntPerson;
			}
			
			
			// 만약 M 크다면, 시간이 더 필요하다.
            if (sum >= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
		}
		System.out.println(left);
	}

}
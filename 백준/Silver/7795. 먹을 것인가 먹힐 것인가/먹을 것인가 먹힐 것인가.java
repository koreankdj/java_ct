import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int ans;
	static int[] arr_a, arr_b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int size_a = Integer.parseInt(st.nextToken());
			int size_b = Integer.parseInt(st.nextToken());
			arr_a = new int[size_a];
			arr_b = new int[size_b];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size_a; i++) {
				arr_a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size_b; i++) {
				arr_b[i] = Integer.parseInt(st.nextToken());
			}
			
			// b 배열 정렬
			Arrays.sort(arr_b);

			int mid = 0;
			ans = 0;
			
			
			for(int i = 0; i < arr_a.length; i++) {
				ans += binarySearch(arr_b, arr_a[i]);
			}
			System.out.println(ans);
		}
	}
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length-1;
		int result = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			// 타겟이 클 경우
			if(arr[mid] < target) {
				result = mid + 1;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		
		return result;
		
		
	}
}
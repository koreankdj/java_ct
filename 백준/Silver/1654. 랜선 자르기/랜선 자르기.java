import java.util.Arrays;
import java.util.Scanner;

/*
 * N개의 랜선 만들기, 
 * 이미 K개의 랜선이 있음
 * 
 * 300짜리 140 두 개 자르면 20 버림
 * N개보다 많이 만드는 것도 N개를 만드는 것에 포함
 * 만들 수 있는 최대 랜선의 길이 구하기
 * 
 * 
 */

public class Main {
	
	static int K, N; 
	static long ans;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		N = sc.nextInt();
		
		arr = new int[K];
		for(int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 이분탐색 전 반드시 정렬
		Arrays.sort(arr);
		
		binarySearch(arr, N);
		System.out.println(ans);
	}
	
	public static void binarySearch(int[] arr, int target) {
		long left = 0;
		long right = arr[K-1];
		
		while(left <= right) {
			
			long mid = (left + right) / 2 ;
			
			if(mid == 0) {
				left++;
				continue;
			}
			
			//System.out.println(mid);
			long cnt = cut(arr, mid);
			
			if(cnt < target) { 		// 너무 큰 덩이로 잘랐다.
				right = mid - 1;
				
			}else {					// 너무 작게 잘랐다.
				ans = Math.max(ans, mid);
				left = mid + 1;
			}
		}
	}
	
	public static long cut(int[] arr, long len) {
		long result = 0;
		
		for(int i = 0; i < arr.length; i++) {
			result += arr[i]/len;
		}
		return result;
	}
}
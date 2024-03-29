import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, M;
	static long ans;
	static int[] trees;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		trees = new int[N];
		
		for(int i = 0; i < N; i++) {
			trees[i] = sc.nextInt();
		}
		
		Arrays.sort(trees);
		binarySearch(trees, M);
		System.out.println(ans);
	}
	public static void binarySearch(int[] arr, int target) {
		int left = 1;
		int right = trees[N-1];
		
		long result = 0;	// 자른 나무의 총 합
		
		while(left <= right) {
			
			int mid = (left + right) / 2;
			
			if(mid == 0) {
				left++;
				continue;
			}
			
			result = cut(arr, mid);
			
			// 덜 자른 경우
			if(result < target) {
				right = mid-1;
			}else {		// M 이상 자른 경우
				ans = Math.max(ans, mid);
				left = mid+1;
			}
			
		}
	}
	
	public static long cut(int[] arr, int len) {
		long result = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > len) {
				result+= arr[i]-len;
			}
		}
		
		return result;
	}
}
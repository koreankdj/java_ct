import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int M = sc.nextInt();
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int left = 0, right = N-1;
		
		int ans = 0;
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			if(sum == M) ans++;
			
			if(sum > M) {
				right--;
			}else if(sum <= M) {
				left++;
			}
			
		}
		
		System.out.println(ans);
		
	}

}
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
		}
		
		for(int i = 0; i < n; i++) {
			int max_n = 0;
			for(int j = i; j >= 0; j--) {
				if(arr[i] > arr[j]) max_n = Math.max(max_n, dp[j]);
			}
			dp[i] = max_n + 1;
		}
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}

}
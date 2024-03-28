import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int left = 1, right = 1;
		int sum = 1, count = 0;
		
		while(left <= right) {
			if(sum == N) count++;
			
			if(sum < N) {
				right++;
				sum += right;
			}else if(sum >= N) {
				sum -= left;
				left++;
			}
			
			
		}
		System.out.println(count);
	}

}
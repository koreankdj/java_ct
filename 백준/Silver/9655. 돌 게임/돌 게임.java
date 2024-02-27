import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] win = new int[N+1];
		win[0] = 1;
		win[1] = 0;
		if(N == 2) {
			System.out.println("CY");
			return;
		}
		
		if(N >= 3) {
			win[2] = 1;
			for(int i = 3; i < N+1; i++) {
				win[i] = win[i-3] == 0 ? 1 : 0;
			}
		}
		
		System.out.println(win[N] == 0 ? "SK" : "CY");
	}

}
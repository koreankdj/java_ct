import java.util.Scanner;

public class Main {

	static int N;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		solve();
	}
	
	public static void solve() {
		
		int cnt = 0;
		
		while(N > 0) {
			if(N % 5 == 0) {
				cnt += N / 5;
				N = 0;
				break;
			}else {
				N -= 3;
				cnt++;
			}
		}
		
		if(N == 0) {
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
		
	}

}
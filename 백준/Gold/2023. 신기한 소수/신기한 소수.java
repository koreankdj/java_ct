import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] sosu  = {2, 3, 5, 7};
	static int[] odd = {1, 3, 7, 9};		// 5는 제외
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		solve(N);
	}
	
	private static void solve(int len) {
		
		// 1자리 수 일 경우
		if(len == 1) for(int num : sosu) System.out.println(num);
		
		if(len > 1) {
			for(int num : sosu) {
				make_num(num, 1);
			}
		}
		return;
	}
	
	public static void make_num(int num, int depth) {
		
		if(depth == N) {
			System.out.println(num);
			return;
		}
		for(int i = 0; i < 4; i++) {
			
			int next_num = (int)(num * Math.pow(10, 1)) + odd[i];
			if(!check_prime(next_num)) continue;
			
			make_num(next_num, depth + 1);
		}
	}
	
	public static boolean check_prime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {

			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, r, c;
	static long cnt;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		cnt = 0;
		int size = (int) Math.pow(2, N);
		binarySearch(0, 0, size);
	}
	
	public static void binarySearch(int x, int y, int size) {
		
		
		// 기저
		if(x == r && y == c) {
			System.out.println(cnt);
			return;
		}
		
		int half = (size / 2);
		long s_size = (half * half);
		
		if(r < x + half && c < y + half) {
			binarySearch(x, y, half);
		}else if(r >= x + half && c < y + half) {
			cnt += s_size;
			binarySearch(x + half, y, half);
		}else if(r < x + half && c >= y + half) {
			cnt += s_size * 2;
			binarySearch(x, y + half, half);
		}else {
			cnt += s_size * 3;
			binarySearch(x + half, y + half, half);
		}
		
	}

}
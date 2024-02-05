import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int N, K;
	static ArrayList<Integer> nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		
		for(int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			nums = new ArrayList<>(10);
			
			st = new StringTokenizer(br.readLine());
			
			// 원본 암호문 입력 받음
			for(int i = 0; i < 10; i++) {
				nums.add(Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			// 명령어의 개수
			K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int x = 0;
				int y = 0;
				if(st.nextToken().equals("I")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
				}
				for(int i = 0; i < y; i++) {
					if(x + i < 10) nums.add(x + i, Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.printf("#%d ", tc);
			for(int i = 0; i < 10; i++) {
				System.out.print(nums.get(i) + " ");
			}
			System.out.println();
		}
		
	}
	
}
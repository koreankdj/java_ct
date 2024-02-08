import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	final static int SIZE = 8;
	static Queue<Integer> nums;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			nums = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				nums.offer(Integer.parseInt(st.nextToken()));
			}
			
			// 1 cycle
			Loop:
				while(true) {
					for(int i = 1; i <= 5; i++) {
						int temp;
						temp = nums.poll();
						temp -= i;
						if(temp <= 0) {
							nums.add(0);
							break Loop;
						}
						nums.offer(temp);
					}
				}
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < SIZE; i++) {
				System.out.print(nums.poll() + " ");
			}
			System.out.println();
		}
		
		
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		for(int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = 1;
			
			// n 개의 정점 정보를 받음
			while(N-- > 0) {
				st = new StringTokenizer(br.readLine());
				
				if(st.countTokens() == 2) {
					st.nextToken();
					if(!Character.isDigit(st.nextToken().charAt(0))) {
						ans = 0;
					}
				}else if(st.countTokens() == 4) {
					st.nextToken();
					if(Character.isDigit(st.nextToken().charAt(0))) {
						ans = 0;
					}
				}
				if(N==0) System.out.printf("#%d %d\n", tc, ans);
			}
			
		}
	}

}
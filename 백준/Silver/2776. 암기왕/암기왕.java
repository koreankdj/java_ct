import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int T, N, M;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			Set<Integer> set = new HashSet<>();
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				if(set.contains(Integer.parseInt(st.nextToken()))){
					sb.append("1\n");
				}else{
					sb.append("0\n");
				}
			}
			
			System.out.print(sb);
		}
	}
}
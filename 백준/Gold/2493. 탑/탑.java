import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N;
	
	static class Top{
		int num;
		int idx;
		public Top(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}
	static Stack<Top> tops;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		tops = new Stack<>();
		
		for(int i = 1; i <= N; i++) {

			Top n_T = new Top(Integer.parseInt(st.nextToken()), i);
			while(!tops.isEmpty()) {
				//System.out.printf("지금 맨 위 : [%d %d]\n", tops.peek().idx, tops.peek().num);
				Top t_T = tops.pop();
				if(n_T.num > t_T.num) {
					continue;
				}else {
					tops.add(t_T);
					tops.add(n_T);
					sb.append(t_T.idx).append(" ");
					break;
				}
			}
			
			if(tops.isEmpty()) {
				sb.append(0).append(" ");
				tops.add(n_T);
				continue;
			}
		}
		
		System.out.println(sb);
		

		
	}

}
